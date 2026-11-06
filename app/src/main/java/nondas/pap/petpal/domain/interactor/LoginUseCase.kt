package nondas.pap.petpal.domain.interactor

import kotlinx.coroutines.CoroutineDispatcher
import nondas.pap.petpal.domain.executor.IoDispatcher
import nondas.pap.petpal.domain.repository.UserRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val userRepository: UserRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): SuspendUseCase<Unit, LoginUseCase.Params>(dispatcher) {


    override suspend fun invoke(params: Params) {
        userRepository.login(params.email, params.password)
    }


    data class Params(
        val email: String,
        val password: String
    )
}



