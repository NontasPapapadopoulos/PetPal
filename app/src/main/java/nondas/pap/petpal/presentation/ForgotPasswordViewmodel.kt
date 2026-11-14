package nondas.pap.petpal.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import nondas.pap.petpal.domain.interactor.user.SendResetPasswordLink
import javax.inject.Inject


@HiltViewModel
class ForgotPasswordViewmodel @Inject constructor(
    private val sendResetPasswordLink: SendResetPasswordLink
): ViewModel() {

    private val _navigationFlow = MutableSharedFlow<Unit>()
    val navigationFlow: SharedFlow<Unit> = _navigationFlow

    private val _messageFlow = MutableSharedFlow<String>()
    val messageFlow: SharedFlow<String> = _messageFlow

    fun onSendResetLink(email: String) {
        viewModelScope.launch {
            sendResetPasswordLink.execute(SendResetPasswordLink.Params(email))
                .fold(
                    onSuccess = {
                        _messageFlow.emit("Email sent")
                    },
                    onFailure = {
                        _messageFlow.emit("Email not found")
                    }
                )
        }
    }
}


