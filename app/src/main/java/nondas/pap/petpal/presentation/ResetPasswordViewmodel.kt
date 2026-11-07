package nondas.pap.petpal.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import nondas.pap.petpal.domain.interactor.user.ResetPassword
import javax.inject.Inject

@HiltViewModel
class ResetPasswordViewmodel @Inject constructor(
    private val resetPassword: ResetPassword
): PetPalViewModel<Unit>() {

    fun onResetPassword(
        password: String,
        confirmPassword: String
    ) {

    }
}




