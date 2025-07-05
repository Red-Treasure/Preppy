package org.redtreasure.preppy.ui.settings

import kotlinx.coroutines.flow.StateFlow
import org.redtreasure.preppy.settings.ThemeSettings

interface SettingsViewModel {
    val themeSetting: StateFlow<ThemeSettings>
    fun updateThemeSetting(theme: ThemeSettings)
}