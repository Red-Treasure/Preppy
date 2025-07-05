package org.redtreasure.preppy.settings

import com.russhwolf.settings.Settings
import org.redtreasure.preppy.settings.repository.SettingsRepository


expect fun createSettingsRepository(): SettingsRepository

expect fun createSettings(): Settings
