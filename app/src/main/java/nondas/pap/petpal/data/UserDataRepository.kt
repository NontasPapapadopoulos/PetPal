package nondas.pap.petpal.data

import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import nondas.pap.petpal.domain.model.User
import nondas.pap.petpal.domain.repository.UserRepository

class UserDataRepository(
    private val firestore: FirebaseFirestore
): UserRepository {

    override suspend fun login(email: String, password: String) {
        val auth = FirebaseAuth.getInstance()

        val authResult = auth
            .signInWithEmailAndPassword(email, password)
            .await()


        firestore.collection(COLLECTION_NAME)
            .document(authResult.user!!.uid)
            .get()
            .await()
            .toObject(User::class.java)

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