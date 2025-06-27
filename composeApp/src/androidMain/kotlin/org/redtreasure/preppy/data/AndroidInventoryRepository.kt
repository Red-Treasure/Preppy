package org.redtreasure.preppy.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * The Android-specific implementation of the repository interface.
 * This class uses the Room DAO to interact with the database and handles
 * the mapping between domain models and database entities.
 */
class AndroidInventoryRepository(private val inventoryItemDao: InventoryItemDao) : InventoryRepository {
    override fun getAllItems(): Flow<List<InventoryItem>> {
        return inventoryItemDao.getAllItems().map { entityList ->
            entityList.map { it.toDomain() }
        }
    }

    override fun getItemById(id: Int): Flow<InventoryItem> {
        return inventoryItemDao.getItemById(id).map { it.toDomain() }
    }

    override suspend fun insert(item: InventoryItem) {
        inventoryItemDao.insert(item.toEntity())
    }

    override suspend fun update(item: InventoryItem) {
        inventoryItemDao.update(item.toEntity())
    }

    override suspend fun delete(item: InventoryItem) {
        inventoryItemDao.delete(item.toEntity())
    }
}