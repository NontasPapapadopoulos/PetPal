package nondas.pap.petpal.domain.repository

interface SettingsRepository {
    suspend fun togglePushNotifications()
    suspend fun setTheme()

}