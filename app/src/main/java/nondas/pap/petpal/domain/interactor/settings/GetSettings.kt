package nondas.pap.petpal.domain.interactor.settings

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import nondas.pap.petpal.domain.FlowUseCase
import nondas.pap.petpal.domain.executor.IoDispatcher
import nondas.pap.petpal.domain.model.Settings
import nondas.pap.petpal.domain.repository.SettingsRepository
import javax.inject.Inject

class GetSettings @Inject constructor(
    private val settingsRepository: SettingsRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
): FlowUseCase<Settings, Unit>(dispatcher) {

    override fun invoke(params: Unit): Flow<Settings> {
        return settingsRepository.get()
    }


}
