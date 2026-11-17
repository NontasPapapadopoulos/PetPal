package nondas.pap.petpal.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import nondas.pap.petpal.domain.execute
import nondas.pap.petpal.domain.interactor.settings.GetSettings
import nondas.pap.petpal.domain.model.Settings
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSettings: GetSettings
): ViewModel() {


    val state: StateFlow<Settings> = getSettings.execute()
        .map { it.getOrThrow() }
        .catch { it }
        .stateIn(
            scope = viewModelScope,
            initialValue = Settings.DEFAULT,
            started = SharingStarted.WhileSubscribed()
        )

}