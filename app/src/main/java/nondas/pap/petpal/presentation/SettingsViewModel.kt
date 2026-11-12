package nondas.pap.petpal.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import nondas.pap.petpal.domain.execute
import nondas.pap.petpal.domain.interactor.settings.GetSettings
import nondas.pap.petpal.domain.interactor.settings.UpdateSettings
import nondas.pap.petpal.domain.interactor.user.DeleteAccount
import nondas.pap.petpal.domain.interactor.user.GetUser
import nondas.pap.petpal.domain.interactor.user.SignOut
import nondas.pap.petpal.domain.model.Settings
import nondas.pap.petpal.domain.model.User
import nondas.pap.petpal.domain.model.enums.Theme
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val getUser: GetUser,
    private val getSettings: GetSettings,
    private val updateSettings: UpdateSettings,
    private val signOut: SignOut,
    private val deleteAccount: DeleteAccount
): ViewModel()  {

    private val _navigationFlow = MutableSharedFlow<Unit>()
    val navigationFlow: SharedFlow<Unit> = _navigationFlow

    private val userFlow = getUser.execute()
        .map { it.getOrThrow() }
        .catch {

        }

    private val settingsFlow = getSettings.execute()
        .map { it.getOrThrow() }
        .catch {

        }

    val state: StateFlow<SettingsState> = combine(
        settingsFlow,
        userFlow
    ) { settings, user ->
            SettingsState(
                settings,
                user
            )
        }.stateIn(
            scope = viewModelScope,
            initialValue = SettingsState(),
            started = SharingStarted.WhileSubscribed()
        )


    fun onUpdateTheme(theme: Theme) {
        val updatedSettings = state.value.settings.copy(theme = theme)
        viewModelScope.launch {
            updateSettings.execute(UpdateSettings.Params(updatedSettings))
                .fold(
                    onSuccess = {},
                    onFailure = {}
                )
        }
    }

    fun onTogglePushNotifications(enabled: Boolean) {
        val updatedSettings = state.value.settings.copy(pushNotificationsEnabled = enabled)
        viewModelScope.launch {
            updateSettings.execute(UpdateSettings.Params(updatedSettings))
                .fold(
                    onSuccess = {},
                    onFailure = {}
                )
        }
    }

    fun onDeleteAccount(password: String) {
        viewModelScope.launch {
            deleteAccount.execute(DeleteAccount.Params(password))
                .fold(
                    onSuccess = {
                        _navigationFlow.emit(Unit)
                    },
                    onFailure = {}
                )
        }
    }

    fun onSignOut() {
        viewModelScope.launch {
            signOut.execute(Unit)
                .fold(
                    onSuccess = {
                        _navigationFlow.emit(Unit)
                    },
                    onFailure = {}
                )
        }
    }
}

data class SettingsState(
    val settings: Settings = Settings(true, Theme.Light),
    val user: User = User("", "")
)