package org.redtreasure.preppy.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface InventoryItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: InventoryItemEntity)
    @Update
    suspend fun update(item: InventoryItemEntity)
    @Delete
    suspend fun delete(item: InventoryItemEntity)
    @Query("SELECT * FROM inventory_items ORDER BY name ASC")
    fun getAllItems(): Flow<List<InventoryItemEntity>>
    @Query("SELECT * FROM inventory_items WHERE id = :id")
    fun getItemById(id: Int): Flow<InventoryItemEntity>
}