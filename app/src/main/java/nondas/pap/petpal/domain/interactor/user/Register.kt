package nondas.pap.petpal.domain.interactor.user

import kotlinx.coroutines.CoroutineDispatcher
import nondas.pap.petpal.domain.PasswordsDoNotMatchException
import nondas.pap.petpal.domain.executor.IoDispatcher
import nondas.pap.petpal.domain.interactor.SuspendUseCase
import nondas.pap.petpal.domain.model.User
import nondas.pap.petpal.domain.repository.UserRepository
import javax.inject.Inject

class Register @Inject constructor(
    private val userRepository: UserRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): SuspendUseCase<Unit, Register.Params>(dispatcher) {


    override suspend fun invoke(params: Params) {
        if (params.password != params.confirmPassword)
            throw PasswordsDoNotMatchException

        val newAccount = User(
            fullName = params.name,
            email = params.email,
            password = params.password
        )

        userRepository.register(newAccount)
    }


    data class Params(
        val name: String,
        val email: String,
        val password: String,
        val confirmPassword: String,
    )
}



