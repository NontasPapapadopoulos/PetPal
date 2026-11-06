package nondas.pap.petpal.domain.interactor

import kotlinx.coroutines.CoroutineDispatcher
import nondas.pap.petpal.domain.executor.IoDispatcher
import nondas.pap.petpal.domain.repository.UserRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val userRepository: UserRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): SuspendUseCase<Unit, RegisterUseCase.Params>(dispatcher) {


    override suspend fun invoke(params: Params) {
        userRepository.register(params.name, params.email, params.password)
    }


    data class Params(
        val name: String,
        val email: String,
        val password: String,
        val confirmPassword: String,
    )
}



