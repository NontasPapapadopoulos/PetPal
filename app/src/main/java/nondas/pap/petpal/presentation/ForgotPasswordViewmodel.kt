package nondas.pap.petpal.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject


@HiltViewModel
class ForgotPasswordViewmodel @Inject constructor(

): ViewModel() {

    private val _navigationFlow = MutableSharedFlow<Unit>()
    val navigationFlow: SharedFlow<Unit> = _navigationFlow

    private val _messageFlow = MutableSharedFlow<String>()
    val messageFlow: SharedFlow<String> = _messageFlow

    fun onSendResetLink(email: String) {

    }
}


