package org.redtreasure.preppy.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import org.redtreasure.preppy.settings.ThemeSettings
import org.redtreasure.preppy.ui.settings.SettingsScreen
import org.redtreasure.preppy.ui.settings.SettingsViewModel
import org.redtreasure.preppy.ui.settings.SettingsViewModelImpl
import org.redtreasure.preppy.ui.theme.PreppyTheme

@Composable
public fun App() {
    val inventoryViewModel: InventoryViewModel = viewModel(
        key = "InventoryViewModel",
        factory = ViewModelFactory)
    // Using Impl vs Interface is a workaround as somehow the interface type is
    // not being translated to the ViewModelFactory properly.
    val settingsViewModel: SettingsViewModelImpl = viewModel(
        key = "SettingsViewModel",
        factory = ViewModelFactory)

    val themeSetting by settingsViewModel.themeSetting.collectAsState()

    var currentScreen by remember { mutableStateOf("inventory") }

    PreppyTheme (
        useDarkTheme = when (themeSetting) {
            ThemeSettings.Light -> false
            ThemeSettings.Dark -> true
            ThemeSettings.System -> isSystemInDarkTheme()
        }
    ) {
        // TODO: Implement real Navigation
        when (currentScreen) {
            "inventory" -> InventoryScreen(inventoryViewModel, onNavigateToSettings = { currentScreen = "settings" })
            "settings" -> SettingsScreen(settingsViewModel, onNavigateBack = { currentScreen = "inventory" })
        }
    }
}