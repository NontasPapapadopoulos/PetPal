package nondas.pap.petpal.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import nondas.pap.petpal.ui.screen.PetScreen
import nondas.pap.petpal.ui.screen.ForgotPasswordScreen
import nondas.pap.petpal.ui.screen.HomeScreen
import nondas.pap.petpal.ui.screen.LoginScreen
import nondas.pap.petpal.ui.screen.MedicineScreen
import nondas.pap.petpal.ui.screen.PetDetailsScreen
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
                        HomeScreen(
                            navigateToSettings = { backStack.add(Settings) },
                            navigateToAddPet = { backStack.add(Pet(petId = "")) },
                            navigateToPet = { backStack.add(PetDetails(petId = it)) },
                            navigateToNotifications = { backStack.add(Notifications) },
                        )
                    }

                is Settings ->
                    NavEntry(key = route) {
                        SettingsScreen(
                            navigateToHome = { backStack.add(Home) },
                            navigateToLogin = { backStack.add(Login) },
                            navigateToChangePassword = { backStack.add(ChangePassword) }
                        )
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

                is PetDetails ->
                    NavEntry(key = route) {
                        PetDetailsScreen(
                            petId = route.petId,
                            navigateBack = { backStack.removeLastOrNull() },
                            navigateToMedicine = { petId, medicineId -> backStack.add(Medicine(petId, medicineId)) },
                            navigateToEditPet = { backStack.add(Pet(petId = it)) }
                        )
                    }

                is Pet ->
                    NavEntry(key = route) {
                        PetScreen(
                            navigateBack = { backStack.removeLastOrNull() },
                            petId = route.petId
                        )
                    }

                is Medicine ->
                    NavEntry(key = route) {
                        MedicineScreen(
                            navigateBack = { backStack.removeLastOrNull() },
                            petId = route.petId,
                            medicineId = route.medicineId
                        )
                    }

                else -> error("Unknown route: $route")

            }
        }
    )
}
