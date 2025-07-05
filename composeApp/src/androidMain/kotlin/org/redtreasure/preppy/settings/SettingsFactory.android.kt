package org.redtreasure.preppy.settings

import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import org.redtreasure.preppy.PreppyApplication
import org.redtreasure.preppy.settings.repository.SettingsRepository
import org.redtreasure.preppy.settings.repository.SettingsRepositoryImpl

actual fun createSettingsRepository(): SettingsRepository {
    return SettingsRepositoryImpl(createSettings() as SharedPreferencesSettings)
}

actual fun createSettings(): Settings {
    return SharedPreferencesSettings.Factory(PreppyApplication.instance).create("AndroidSettings")
}