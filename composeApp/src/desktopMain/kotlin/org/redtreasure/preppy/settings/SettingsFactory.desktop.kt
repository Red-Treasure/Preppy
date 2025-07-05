package org.redtreasure.preppy.settings

import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import org.redtreasure.preppy.settings.repository.SettingsRepository
import org.redtreasure.preppy.settings.repository.SettingsRepositoryImpl

actual fun createSettingsRepository(): SettingsRepository {
    return SettingsRepositoryImpl(createSettings() as PreferencesSettings)
}

actual fun createSettings(): Settings {
    return PreferencesSettings.Factory().create("DesktopSettings")
}