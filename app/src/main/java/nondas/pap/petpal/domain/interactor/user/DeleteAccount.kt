package nondas.pap.petpal.domain.interactor.user

import kotlinx.coroutines.CoroutineDispatcher
import nondas.pap.petpal.domain.executor.IoDispatcher
import nondas.pap.petpal.domain.interactor.SuspendUseCase
import nondas.pap.petpal.domain.repository.UserRepository
import javax.inject.Inject

class DeleteAccount @Inject constructor(
    private val userRepository: UserRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): SuspendUseCase<Unit, DeleteAccount.Params>(dispatcher) {


    override suspend fun invoke(params: Params) {
        userRepository.login(params.email, params.password)
    }


    data class Params(
        val email: String,
        val password: String
    )
}



