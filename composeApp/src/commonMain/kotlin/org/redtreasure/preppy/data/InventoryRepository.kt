package org.redtreasure.preppy.data

import kotlinx.coroutines.flow.Flow

/**
 * The common interface for the inventory repository.
 * This defines the contract that the shared ViewModel will use.
 * It has no knowledge of the underlying data source (Room, Core Data, etc.).
 */
interface InventoryRepository {
    fun getAllItems(): Flow<List<InventoryItem>>
    fun getItemById(id: Int): Flow<InventoryItem>
    suspend fun insert(item: InventoryItem)
    suspend fun update(item: InventoryItem)
    suspend fun delete(item: InventoryItem)
}