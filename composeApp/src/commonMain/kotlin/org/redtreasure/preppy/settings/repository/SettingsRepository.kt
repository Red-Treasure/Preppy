package org.redtreasure.preppy.settings.repository

import kotlinx.coroutines.flow.Flow
import org.redtreasure.preppy.settings.ThemeSettings

interface SettingsRepository {
    val themeSetting: Flow<ThemeSettings>
    suspend fun saveThemeSetting(themeSetting: ThemeSettings)
}