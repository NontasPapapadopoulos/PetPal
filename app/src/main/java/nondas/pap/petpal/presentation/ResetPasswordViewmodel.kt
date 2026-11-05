package nondas.pap.petpal.presentation

import nondas.pap.petpal.domain.interactor.ResetPasswordUseCase

class ResetPasswordViewmodel(
    private val resetPasswordUseCase: ResetPasswordUseCase
): PetPalViewModel<Unit>() {

    fun onResetPassword(
        password: String,
        confirmPassword: String
    ) {

    }
}




