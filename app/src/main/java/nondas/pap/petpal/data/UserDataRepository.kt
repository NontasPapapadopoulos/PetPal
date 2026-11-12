package nondas.pap.petpal.data

import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.snapshots
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import nondas.pap.petpal.domain.model.User
import nondas.pap.petpal.domain.repository.UserRepository

class UserDataRepository(
    private val firestore: FirebaseFirestore
): UserRepository {


    override fun get(): Flow<User> {
        val user = FirebaseAuth.getInstance().currentUser
            ?: throw IllegalStateException("Not authenticated")


        return firestore.collection(COLLECTION_NAME)
            .document(user.uid)
            .snapshots()
            .map { it.toObject(User::class.java) ?: throw IllegalStateException("User not found") }
    }

    override suspend fun login(email: String, password: String) {
        val auth = FirebaseAuth.getInstance()

        val authResult = auth
            .signInWithEmailAndPassword(email, password)
            .await()

    }

    override suspend fun loginWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        val authResult = FirebaseAuth.getInstance()
            .signInWithCredential(credential)
            .await()

        val isNewUser = authResult.additionalUserInfo?.isNewUser ?: false

        if (isNewUser) {
            val user = authResult.user!!
            firestore.collection(COLLECTION_NAME).document(user.uid)
                .set(
                    User(
                        fullName = user.displayName ?: "",
                        email = user.email ?: ""
                    )
                )
                .await()
        }
    }

    override suspend fun register(user: User) {
        val auth = FirebaseAuth.getInstance()

        val authResult = auth
            .createUserWithEmailAndPassword(user.email, user.password!!)
            .await()

        val profile = user.copy(password = null)

        firestore.collection(COLLECTION_NAME)
            .document(authResult.user!!.uid)
            .set(profile)
            .await()
    }

    override suspend fun changePassword(oldPassword: String, newPassword: String) {
        val user = FirebaseAuth.getInstance().currentUser
            ?: throw IllegalStateException("Not authenticated")

        val credential = EmailAuthProvider.getCredential(user.email!!, oldPassword)
        user.reauthenticate(credential).await()

        user.updatePassword(newPassword).await()
    }

    override suspend fun sendResetLink(email: String) {
        FirebaseAuth.getInstance()
            .sendPasswordResetEmail(email)
            .await()

    }

    override fun signOut() {
        FirebaseAuth.getInstance().signOut()
    }

    override suspend fun deleteAccount(password: String) {
        val user = FirebaseAuth.getInstance().currentUser
            ?: throw IllegalStateException("Not authenticated")

        val credential = EmailAuthProvider.getCredential(user.email!!, password)
        user.reauthenticate(credential).await()

        val uid = user.uid

        eraseUserData(uid)

        firestore.collection(COLLECTION_NAME).document(user.uid)
            .delete()
            .await()

        user.delete().await()

    }

    private suspend fun eraseUserData(uid: String) {
        val pets = firestore.collection(PET_COLLECTION)
            .whereEqualTo("ownerId", uid)
            .get()
            .await()
            .documents

        pets.forEach { petDoc ->
            val petId = petDoc.id

            val medicines = firestore.collection(PET_COLLECTION).document(petId)
                .collection(MEDICINE_COLLECTION)
                .get()
                .await()
                .documents

            medicines.forEach { it.reference.delete().await() }

            petDoc.reference.delete().await()
        }
    }


    companion object {
        private const val COLLECTION_NAME = "User"
        private const val PET_COLLECTION = "Pet"
        private const val MEDICINE_COLLECTION = "Medicine"
    }


}