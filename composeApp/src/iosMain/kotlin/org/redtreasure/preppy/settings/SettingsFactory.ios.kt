package org.redtreasure.preppy.settings

import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import org.redtreasure.preppy.settings.repository.SettingsRepository
import org.redtreasure.preppy.settings.repository.SettingsRepositoryImpl

actual fun createSettingsRepository(): SettingsRepository {
    return SettingsRepositoryImpl(createSettings() as NSUserDefaultsSettings)
}

actual fun createSettings(): Settings {
    return NSUserDefaultsSettings.Factory().create("iOsSettings")
}