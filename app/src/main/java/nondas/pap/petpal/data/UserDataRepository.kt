package nondas.pap.petpal.data

import com.google.firebase.firestore.FirebaseFirestore
import nondas.pap.petpal.domain.model.NewAccount
import nondas.pap.petpal.domain.repository.UserRepository

class UserDataRepository(
    private val firestore: FirebaseFirestore
): UserRepository {

    override suspend fun login(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun register(account: NewAccount) {
        TODO("Not yet implemented")
    }

    override suspend fun changePassword(newPassword: String) {
        TODO("Not yet implemented")
    }

    override suspend fun sendResetLink(email: String) {
        TODO("Not yet implemented")
    }

    override suspend fun signOut() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAccount() {
        TODO("Not yet implemented")
    }

    override fun emailExists(email: String): Boolean {
        TODO("Not yet implemented")
    }

    companion object {
        private const val COLLECTION_NAME = "User"
    }


}