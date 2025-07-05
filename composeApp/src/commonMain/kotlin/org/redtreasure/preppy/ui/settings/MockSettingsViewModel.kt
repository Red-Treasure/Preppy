package org.redtreasure.preppy.ui.settings

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.redtreasure.preppy.settings.ThemeSettings

// Used for Composable Preview and testing
open class MockSettingsViewModel : SettingsViewModel {
    private val _themeSetting = MutableStateFlow(ThemeSettings.System)
    override val themeSetting: StateFlow<ThemeSettings> = _themeSetting

    var lastUpdatedTheme: ThemeSettings? = null

    override fun updateThemeSetting(theme: ThemeSettings) {
        lastUpdatedTheme = theme
        _themeSetting.value = theme
    }

    fun setCurrentTheme(theme: ThemeSettings) {
        _themeSetting.value = theme
    }
}