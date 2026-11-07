package nondas.pap.petpal.domain.interactor.user

import kotlinx.coroutines.CoroutineDispatcher
import nondas.pap.petpal.domain.executor.IoDispatcher
import nondas.pap.petpal.domain.interactor.SuspendUseCase
import nondas.pap.petpal.domain.repository.UserRepository
import javax.inject.Inject

class ResetPassword @Inject constructor(
    private val userRepository: UserRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): SuspendUseCase<Unit, ResetPassword.Params>(dispatcher) {


    override suspend fun invoke(params: Params) {
        userRepository.changePassword(params.confirmPassword)
    }


    data class Params(
        val password: String,
        val confirmPassword: String
    )
}



