package nondas.pap.petpal.domain.repository

interface UserRepository {
    suspend fun login(email: String, password: String)
}