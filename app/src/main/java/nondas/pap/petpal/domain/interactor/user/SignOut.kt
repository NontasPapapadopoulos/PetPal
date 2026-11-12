package nondas.pap.petpal.domain.interactor.user

import kotlinx.coroutines.CoroutineDispatcher
import nondas.pap.petpal.domain.executor.IoDispatcher
import nondas.pap.petpal.domain.interactor.SuspendUseCase
import nondas.pap.petpal.domain.repository.UserRepository
import javax.inject.Inject

class SignOut @Inject constructor(
    private val userRepository: UserRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): SuspendUseCase<Unit, Unit>(dispatcher) {


    override suspend fun invoke(params: Unit) {
        userRepository.signOut()
    }



}



