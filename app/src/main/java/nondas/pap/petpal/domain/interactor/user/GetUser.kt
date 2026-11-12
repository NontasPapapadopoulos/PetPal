package nondas.pap.petpal.domain.interactor.user

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import nondas.pap.petpal.domain.FlowUseCase
import nondas.pap.petpal.domain.executor.IoDispatcher
import nondas.pap.petpal.domain.model.User
import nondas.pap.petpal.domain.repository.UserRepository
import javax.inject.Inject

class GetUser @Inject constructor(
    private val userRepository: UserRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): FlowUseCase<User, Unit>(dispatcher) {

    override fun invoke(params: Unit): Flow<User> {
        return userRepository.get()
    }


}