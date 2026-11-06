package nondas.pap.petpal.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import nondas.pap.petpal.ui.screen.AddPetScreen
import nondas.pap.petpal.ui.screen.ForgotPasswordScreen
import nondas.pap.petpal.ui.screen.HomeScreen
import nondas.pap.petpal.ui.screen.LoginScreen
import nondas.pap.petpal.ui.screen.MedicineScreen
import nondas.pap.petpal.ui.screen.PetScreen
import nondas.pap.petpal.ui.screen.RegisterScreen
import nondas.pap.petpal.ui.screen.ResetPasswordScreen
import nondas.pap.petpal.ui.screen.SettingsScreen

@Composable
fun Navigation() {

    val backStack = rememberNavBackStack(Login)


    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { route ->
            when (route) {
                is Login ->
                    NavEntry(key= route) {
                        LoginScreen(
                            navigateToHome = { backStack.add(Home) },
                            navigateToForgotPassword = { backStack.add(ForgotPassword) },
                            navigateToCreateAccount = { backStack.add(Register) },
                        )
                    }

                is Register ->
                    NavEntry(key = route) {
                        RegisterScreen(
                            navigateToHomeScreen = { backStack.add(Home) },
                            navigateToLoginScreen = { backStack.add(Login) },
                        )
                    }

                is Home ->
                    NavEntry(key = route) {
                        HomeScreen()
                    }

                is Settings ->
                    NavEntry(key = route) {
                        SettingsScreen()
                    }

                is ForgotPassword ->
                    NavEntry(key = route) {
                        ForgotPasswordScreen(
                            navigateToLoginScreen = { backStack.add(Login) },
                            navigateToResetPasswordScreen = { backStack.add(ResetPassword) },
                        )
                    }

                is ResetPassword ->
                    NavEntry(key = route) {
                        ResetPasswordScreen(
                            navigateToHomeScreen = { backStack.add(Home) },
                        )
                    }

                is Pet ->
                    NavEntry(key = route) {
                        PetScreen()
                    }

                is AddPet ->
                    NavEntry(key = route) {
                        AddPetScreen()
                    }

                is Medicine ->
                    NavEntry(key = route) {
                        MedicineScreen()
                    }

                else -> error("Unknown route: $route")

            }
        }
    )
}
