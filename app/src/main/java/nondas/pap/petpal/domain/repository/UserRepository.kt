package nondas.pap.petpal.domain.repository

interface UserRepository {
    suspend fun login(email: String, password: String)
    suspend fun register(name: String, email: String, password: String)
    suspend fun changePassword(newPassword: String)
    suspend fun sendResetLink(email: String)
    suspend fun signOut()
    suspend fun deleteAccount()
}