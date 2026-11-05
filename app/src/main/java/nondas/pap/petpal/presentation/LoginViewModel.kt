package nondas.pap.petpal.presentation


import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import nondas.pap.petpal.domain.interactor.LoginUseCase

class LoginViewModel(
    private val loginUseCase: LoginUseCase
): PetPalViewModel<LoginNavigationTarget>() {

    private val _uiState = MutableStateFlow(LoginState())
    val uiState: StateFlow<LoginState> = _uiState.asStateFlow()

    fun onLogin(email: String, password: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            loginUseCase.execute(LoginUseCase.Params(email, password))
                .fold(
                    onSuccess = {
                        _uiState.update { it.copy(isLoading = false) }
                        navigateTo(LoginNavigationTarget.Home)
                    },
                    onFailure = { throwable ->
                        addError(throwable)
                        _uiState.update { it.copy(isLoading = false) }
//                        _uiState.update { it.copy(isLoading = false, error = throwable.message) }
                    }
                )
        }
    }

    fun onLoginWithGoogle() {

    }


}

data class LoginState(
    val isLoading: Boolean = false,
    val error: String? = null
) {

}


enum class LoginNavigationTarget {
    Home
}