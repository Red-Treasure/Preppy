package org.redtreasure.preppy.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import org.redtreasure.preppy.data.InventoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.redtreasure.preppy.data.InventoryItem
import kotlin.reflect.KClass

/**
 * A placeholder 'actual' implementation of the ViewModelFactory for iOS.
 * This satisfies the compiler but will crash if used.
 * Replace with a real implementation later.
 */
actual object ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: KClass<T>, extras: CreationExtras): T {
        if (modelClass == InventoryViewModel::class) {
            @Suppress("UNCHECKED_CAST")
            return InventoryViewModel(IosDummyInventoryRepository()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.simpleName}")
    }
}

// A dummy repository for iOS to make the code compile.
private class IosDummyInventoryRepository : InventoryRepository {
    override fun getAllItems(): Flow<List<InventoryItem>> = flowOf(emptyList())
    override fun getItemById(id: Int): Flow<InventoryItem> = flowOf(InventoryItem(name = "Dummy", quantity = 1.0, unit = "item"))
    override suspend fun insert(item: InventoryItem) { TODO("Implement for iOS") }
    override suspend fun update(item: InventoryItem) { TODO("Implement for iOS") }
    override suspend fun delete(item: InventoryItem) { TODO("Implement for iOS") }
}