package nondas.pap.petpal.presentation

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import nondas.pap.petpal.domain.interactor.user.Register
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val register: Register
) : PetPalViewModel<RegisterNavigationTarget>() {


    private val _uiState = MutableStateFlow(RegisterState())
    val uiState: StateFlow<RegisterState> = _uiState


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
                    showMessage("Account Created!")
                    navigateTo(RegisterNavigationTarget.Login)
                },
                onFailure = {
                    addError(it)
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
