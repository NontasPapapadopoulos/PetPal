package nondas.pap.petpal.presentation


import nondas.pap.petpal.domain.interactor.LoginUseCase

class LoginViewModel(
    private val loginUseCase: LoginUseCase
): PetPalViewModel<NavigationTarget>() {


    suspend fun onLogin(email: String, password: String) {
        loginUseCase.execute(LoginUseCase.Params(email, password))
            .fold(
                onSuccess = {
                    navigateTo(NavigationTarget.Home)
                },
                onFailure = {
                    addError(it)
                }
            )

    }
}

data class LoginState(
    val isLoading: Boolean = false,
    val error: String? = null
) {

}


enum class NavigationTarget {
    Home
}