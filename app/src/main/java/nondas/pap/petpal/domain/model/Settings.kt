package nondas.pap.petpal.domain.model

data class Settings(
    val pushNotificationsEnabled: Boolean = true,
    val darkThemeEnabled: Boolean = false,
) {
    companion object {
        val DEFAULT = Settings()
    }
}
