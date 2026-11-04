package nondas.pap.petpal.domain.interactor

import kotlinx.coroutines.CoroutineDispatcher
import nondas.pap.petpal.domain.repository.UserRepository

class LoginUseCase(
    private val userRepository: UserRepository,
    private val dispatcher: CoroutineDispatcher
): SuspendUseCase<Unit, LoginUseCase.Params>(dispatcher) {


    override suspend fun invoke(params: Params) {
        userRepository.login(params.email, params.password)
    }


    data class Params(
        val email: String,
        val password: String
    )
}



