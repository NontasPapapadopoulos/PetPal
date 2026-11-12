package nondas.pap.petpal.domain.repository

import nondas.pap.petpal.domain.model.User

interface UserRepository {
    suspend fun login(email: String, password: String)
    suspend fun loginWithGoogle(idToken: String)
    suspend fun register(user: User)
    suspend fun changePassword(oldPassword: String, newPassword: String)
    suspend fun sendResetLink(email: String)
    fun signOut()
    suspend fun deleteAccount(password: String)
}