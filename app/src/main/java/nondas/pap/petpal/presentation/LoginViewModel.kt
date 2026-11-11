package nondas.pap.petpal.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import nondas.pap.petpal.domain.interactor.user.PerformLogin
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: PerformLogin
): ViewModel() {

    private val _uiState = MutableStateFlow(LoginState())
    val uiState: StateFlow<LoginState> = _uiState.asStateFlow()

    private val _navigationFlow = MutableSharedFlow<Unit>()
    val navigationFlow: SharedFlow<Unit> = _navigationFlow

    fun onLogin(email: String, password: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            loginUseCase.execute(PerformLogin.Params(email, password))
                .fold(
                    onSuccess = {
                        _uiState.update { it.copy(isLoading = false) }
                        _navigationFlow.emit(Unit)
                    },
                    onFailure = { throwable ->
                        _uiState.update { it.copy(isLoading = false, error = throwable.message) }
                    }
                )
        }
    }

    fun onLoginWithGoogle() {

    }


}

sealed interface LoginEvent {
    object onLogin: LoginEvent
}


data class LoginState(
    val isLoading: Boolean = false,
    val error: String? = null
) {

}

