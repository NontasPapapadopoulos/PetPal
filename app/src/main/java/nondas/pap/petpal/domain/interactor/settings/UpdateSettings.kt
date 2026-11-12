package nondas.pap.petpal.domain.interactor.settings

import kotlinx.coroutines.CoroutineDispatcher
import nondas.pap.petpal.domain.executor.IoDispatcher
import nondas.pap.petpal.domain.interactor.SuspendUseCase
import nondas.pap.petpal.domain.model.Settings
import nondas.pap.petpal.domain.repository.SettingsRepository
import javax.inject.Inject

class UpdateSettings @Inject constructor(
    private val settingsRepository: SettingsRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): SuspendUseCase<Unit, UpdateSettings.Params>(dispatcher) {

    override suspend fun invoke(params: Params) {
        settingsRepository.update(params.settings)
    }

    data class Params(val settings: Settings)

}
