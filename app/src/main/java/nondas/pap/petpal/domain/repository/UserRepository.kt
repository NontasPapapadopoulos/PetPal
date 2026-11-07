package nondas.pap.petpal.domain.repository

import nondas.pap.petpal.domain.model.NewAccount

interface UserRepository {
    suspend fun login(email: String, password: String)
    suspend fun register(account: NewAccount)
    suspend fun changePassword(newPassword: String)
    suspend fun sendResetLink(email: String)
    suspend fun signOut()
    suspend fun deleteAccount()
    fun emailExists(email: String): Boolean
}