package nondas.pap.petpal.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ForgotPasswordViewmodel @Inject constructor(

): PetPalViewModel<ForgotPasswordNavigationTarget>() {

    fun onSendResetLink(email: String) {

    }
}



enum class ForgotPasswordNavigationTarget {
    Login,
    ResetPassword
}