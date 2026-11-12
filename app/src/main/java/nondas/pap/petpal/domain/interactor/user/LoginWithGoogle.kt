package nondas.pap.petpal.domain.interactor.user

import kotlinx.coroutines.CoroutineDispatcher
import nondas.pap.petpal.domain.executor.IoDispatcher
import nondas.pap.petpal.domain.interactor.SuspendUseCase
import nondas.pap.petpal.domain.repository.UserRepository
import javax.inject.Inject

class LoginWithGoogle @Inject constructor(
    private val userRepository: UserRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): SuspendUseCase<Unit, LoginWithGoogle.Params>(dispatcher) {


    override suspend fun invoke(params: Params) {
        userRepository.loginWithGoogle(params.token)
    }


    data class Params(
        val token: String
    )
}



