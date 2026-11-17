package nondas.pap.petpal.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


@Serializable
object Login: NavKey


@Serializable
object Register: NavKey


@Serializable
object Home: NavKey


@Serializable
object Notifications: NavKey


@Serializable
object Settings: NavKey


@Serializable
object ForgotPassword: NavKey


@Serializable
object ResetPassword: NavKey


@Serializable
object ChangePassword: NavKey


@Serializable
data class PetDetails(
    val petId: String
): NavKey


@Serializable
data class Pet(
    val petId: String = ""
): NavKey


@Serializable
data class Medicine(
    val petId: String,
    val medicineId: String
): NavKey