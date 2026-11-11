package nondas.pap.petpal.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import nondas.pap.petpal.domain.interactor.user.ResetPassword
import javax.inject.Inject

@HiltViewModel
class ResetPasswordViewmodel @Inject constructor(
    private val resetPassword: ResetPassword
): ViewModel() {


    private val _navigationFlow = MutableSharedFlow<Unit>()
    val navigationFlow: SharedFlow<Unit> = _navigationFlow

    private val _messageFlow = MutableSharedFlow<String>()
    val messageFlow: SharedFlow<String> = _messageFlow

    fun onResetPassword(
        password: String,
        confirmPassword: String
    ) {

    }
}


