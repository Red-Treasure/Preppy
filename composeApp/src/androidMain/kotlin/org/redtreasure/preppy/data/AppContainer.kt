package org.redtreasure.preppy.data

import android.content.Context

interface AppContainer {
    val inventoryRepository: InventoryRepository
    // val recipesRepository: RecipesRepository // Example for the future
}

class DefaultAppContainer(private val context: Context) : AppContainer {
    override val inventoryRepository: InventoryRepository by lazy {
        AndroidInventoryRepository(AppDatabase.getDatabase(context).inventoryItemDao())
    }
}