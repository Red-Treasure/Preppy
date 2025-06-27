package org.redtreasure.preppy.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.redtreasure.preppy.data.InventoryItem
import org.redtreasure.preppy.data.InventoryRepository

// This ViewModel now correctly lives in commonMain and uses the
// multiplatform ViewModel class from the JetBrains library.
class InventoryViewModel(private val repository: InventoryRepository) : ViewModel() {
    val inventoryUiState: StateFlow<InventoryUiState> =
        repository.getAllItems().map { InventoryUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = InventoryUiState()
            )

    fun addItem(name: String, quantity: Double, unit: String) {
        viewModelScope.launch {
            val newItem = InventoryItem(name = name, quantity = quantity, unit = unit)
            repository.insert(newItem)
        }
    }
}

data class InventoryUiState(val itemList: List<InventoryItem> = listOf())