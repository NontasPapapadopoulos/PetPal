package nondas.pap.petpal.domain.interactor.settings

import kotlinx.coroutines.CoroutineDispatcher
import nondas.pap.petpal.domain.executor.IoDispatcher
import nondas.pap.petpal.domain.interactor.SuspendUseCase
import nondas.pap.petpal.domain.repository.SettingsRepository
import javax.inject.Inject

class UpdateSettings @Inject constructor(
    private val settingsRepository: SettingsRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): SuspendUseCase<Unit, Unit>(dispatcher) {

    override suspend fun invoke(params: Unit) {
        TODO("Not yet implemented")
    }


}
