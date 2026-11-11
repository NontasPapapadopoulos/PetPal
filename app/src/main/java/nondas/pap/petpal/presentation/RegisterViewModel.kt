package nondas.pap.petpal.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import nondas.pap.petpal.domain.interactor.user.Register
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val register: Register
): ViewModel() {

    private val _uiState = MutableStateFlow(RegisterState())
    val uiState: StateFlow<RegisterState> = _uiState

    private val _navigationFlow = MutableSharedFlow<RegisterNavigationTarget>()
    val navigationFlow: SharedFlow<RegisterNavigationTarget> = _navigationFlow

    private val _messageFlow = MutableSharedFlow<String>()
    val messageFlow: SharedFlow<String> = _messageFlow

    fun onCreateAccount(
        name: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            register.execute(Register.Params(
                name, email, password, confirmPassword
            )).fold(
                onSuccess = {
                    _messageFlow.emit("Account Created!")
                    _navigationFlow.emit(RegisterNavigationTarget.Login)
                },
                onFailure = {
                    _messageFlow.emit(it.message?: "Something went wrong")
                    _uiState.update { it.copy(isLoading = false) }
                }
            )
        }
    }

    fun onCreateWithGoogle() {}

}



data class RegisterState(
    val isLoading: Boolean = false,
    val error: String? = null
)

enum class RegisterNavigationTarget {
    Home,
    Login
}
