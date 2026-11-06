package nondas.pap.petpal.domain.interactor

import kotlinx.coroutines.CoroutineDispatcher
import nondas.pap.petpal.domain.executor.IoDispatcher
import nondas.pap.petpal.domain.repository.UserRepository
import javax.inject.Inject

class SendResetPasswordLink @Inject constructor(
    private val userRepository: UserRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): SuspendUseCase<Unit, SendResetPasswordLink.Params>(dispatcher) {

    override suspend fun invoke(params: Params) {
        // check first if email is registered.
        userRepository.sendResetLink(params.email)
    }


    data class Params(val email: String)
}