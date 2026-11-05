package nondas.pap.petpal.presentation

class ForgotPasswordViewmodel(

): PetPalViewModel<ForgotPasswordNavigationTarget>() {

    fun onSendResetLink(email: String) {

    }
}



enum class ForgotPasswordNavigationTarget {
    Login,
    ResetPassword
}