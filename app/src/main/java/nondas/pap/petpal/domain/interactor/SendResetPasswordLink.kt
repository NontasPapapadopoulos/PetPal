package nondas.pap.petpal.domain.interactor

import kotlinx.coroutines.CoroutineDispatcher
import nondas.pap.petpal.domain.repository.UserRepository

class SendResetPasswordLink(
    private val userRepository: UserRepository,
    private val dispatcher: CoroutineDispatcher
): SuspendUseCase<Unit, SendResetPasswordLink.Params>(dispatcher) {

    override suspend fun invoke(params: Params) {
        // check first if email is registered.
        userRepository.sendResetLink(params.email)
    }


    data class Params(val email: String)
}