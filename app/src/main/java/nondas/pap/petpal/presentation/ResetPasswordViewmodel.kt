package nondas.pap.petpal.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import nondas.pap.petpal.domain.interactor.ResetPasswordUseCase
import javax.inject.Inject

@HiltViewModel
class ResetPasswordViewmodel @Inject constructor(
    private val resetPasswordUseCase: ResetPasswordUseCase
): PetPalViewModel<Unit>() {

    fun onResetPassword(
        password: String,
        confirmPassword: String
    ) {

    }
}




