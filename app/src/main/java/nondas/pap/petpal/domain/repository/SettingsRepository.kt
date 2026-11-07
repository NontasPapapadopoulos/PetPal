package nondas.pap.petpal.domain.repository

import kotlinx.coroutines.flow.Flow
import nondas.pap.petpal.domain.model.Settings

interface SettingsRepository {
    suspend fun get(): Flow<Settings>
    suspend fun togglePushNotifications()
    suspend fun setTheme()

}