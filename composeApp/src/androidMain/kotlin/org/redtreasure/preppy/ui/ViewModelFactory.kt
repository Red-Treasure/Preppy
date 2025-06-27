package org.redtreasure.preppy.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.redtreasure.preppy.PreppyApplication
import org.redtreasure.preppy.data.AndroidInventoryRepository
import org.redtreasure.preppy.data.AppDatabase

/**
 * The 'actual' implementation of the ViewModelFactory for the Android platform.
 * It provides the concrete InventoryRepository needed by the common ViewModel.
 */
actual object ViewModelFactory : ViewModelProvider.Factory {
    private val application: PreppyApplication
        get() = PreppyApplication.instance

    private val inventoryRepository by lazy {
        AndroidInventoryRepository(AppDatabase.getDatabase(application).inventoryItemDao())
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InventoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return InventoryViewModel(inventoryRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.simpleName}")
    }
}