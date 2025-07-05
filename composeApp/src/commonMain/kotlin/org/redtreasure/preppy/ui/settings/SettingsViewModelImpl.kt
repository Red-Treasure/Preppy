package org.redtreasure.preppy.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.redtreasure.preppy.settings.ThemeSettings
import org.redtreasure.preppy.settings.repository.SettingsRepository

class SettingsViewModelImpl (
    private val settingsRepository: SettingsRepository
) : ViewModel(), SettingsViewModel {
    override val themeSetting: StateFlow<ThemeSettings> = settingsRepository.themeSetting
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = ThemeSettings.System
        )

    override fun updateThemeSetting(theme: ThemeSettings) {
        viewModelScope.launch {
            settingsRepository.saveThemeSetting(theme)
        }
    }
}