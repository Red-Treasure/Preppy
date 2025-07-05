package org.redtreasure.preppy.settings.repository

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.coroutines.getStringFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import org.redtreasure.preppy.settings.ThemeSettings

class SettingsRepositoryImpl(private val settings: ObservableSettings): SettingsRepository {
    @OptIn(ExperimentalSettingsApi::class)
    override val themeSetting: Flow<ThemeSettings> = settings
        .getStringFlow(THEME_SETTING_KEY, ThemeSettings.System.name)
        .map { ThemeSettings.valueOf(it) }
        .catch { ThemeSettings.System }

    override suspend fun saveThemeSetting(themeSetting: ThemeSettings) {
        settings.putString(THEME_SETTING_KEY, themeSetting.name)
    }

    companion object {
        private const val THEME_SETTING_KEY = "theme_setting"
    }
}