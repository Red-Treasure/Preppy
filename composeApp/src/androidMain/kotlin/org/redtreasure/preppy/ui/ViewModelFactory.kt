package org.redtreasure.preppy.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.touchlab.kermit.Logger
import com.russhwolf.settings.ObservableSettings
import org.redtreasure.preppy.PreppyApplication
import org.redtreasure.preppy.data.AndroidInventoryRepository
import org.redtreasure.preppy.data.AppDatabase
import org.redtreasure.preppy.settings.createSettings
import org.redtreasure.preppy.settings.repository.SettingsRepositoryImpl
import org.redtreasure.preppy.ui.settings.SettingsViewModel
import org.redtreasure.preppy.ui.settings.SettingsViewModelImpl

actual object ViewModelFactory : ViewModelProvider.Factory {
    private val TAG = ViewModelFactory::class.simpleName ?: "ViewModelFactory"

    private val inventoryRepository by lazy {
        AndroidInventoryRepository(AppDatabase.getDatabase(PreppyApplication.instance).inventoryItemDao())
    }

    private val settingsRepository by lazy {
        SettingsRepositoryImpl(createSettings() as ObservableSettings)
    }

    private val logger = Logger.withTag(TAG)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Leaving debug log statements to track this issue until it's resolved.
        // TODO: Resolve ViewModel dependency injection issue.
        logger.d("Creating ViewModel: ${modelClass.name}")
        return when {
            // Checking for Impl vs Interface is a workaround as somehow the interface type is
            // not being translated to this layer properly.
            modelClass.isAssignableFrom(SettingsViewModelImpl::class.java) -> {
                logger.d("Creating SettingsViewModel")
                SettingsViewModelImpl(settingsRepository) as T
            }
            modelClass.isAssignableFrom(InventoryViewModel::class.java) -> {
                logger.d("Creating InventoryViewModel")
                InventoryViewModel(inventoryRepository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}