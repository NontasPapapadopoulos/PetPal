package nondas.pap.petpal.data

import nondas.pap.petpal.domain.repository.UserRepository

class UserDataRepository(

): UserRepository {

    override suspend fun login(email: String, password: String) {
        TODO("Not yet implemented")
    }
}