package nondas.pap.petpal.domain.interactor

import kotlinx.coroutines.CoroutineDispatcher
import nondas.pap.petpal.domain.repository.UserRepository

class ResetPasswordUseCase(
    private val userRepository: UserRepository,
    private val dispatcher: CoroutineDispatcher
): SuspendUseCase<Unit, ResetPasswordUseCase.Params>(dispatcher) {


    override suspend fun invoke(params: Params) {
        userRepository.changePassword(params.confirmPassword)
    }


    data class Params(
        val password: String,
        val confirmPassword: String
    )
}



