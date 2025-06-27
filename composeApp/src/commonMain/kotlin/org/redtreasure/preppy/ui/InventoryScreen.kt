package org.redtreasure.preppy.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.redtreasure.preppy.data.InventoryItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventoryScreen(viewModel: InventoryViewModel) {
    val uiState by viewModel.inventoryUiState.collectAsState()
    var showAddItemDialog by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showAddItemDialog = true }) {
                Icon(Icons.Default.Add, contentDescription = "Add Item")
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            if (uiState.itemList.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("No items in inventory. Tap '+' to add one!", style = MaterialTheme.typography.bodyLarge)
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(uiState.itemList) { item ->
                        InventoryItemCard(item = item)
                    }
                }
            }
        }
    }

    if (showAddItemDialog) {
        AddItemDialog(
            onDismiss = { showAddItemDialog = false },
            onConfirm = { name, quantity, unit ->
                viewModel.addItem(name, quantity, unit)
                showAddItemDialog = false
            }
        )
    }
}

@Composable
fun InventoryItemCard(item: InventoryItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = item.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = "Quantity: ${item.quantity} ${item.unit}", fontSize = 14.sp)
            }
            item.expiryDate?.let { timestamp ->
                // UPDATED: Use kotlinx-datetime for multiplatform date handling.
                val instant = Instant.fromEpochMilliseconds(timestamp)
                val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
                // Basic formatting. For more complex patterns, you'd build the string manually.
                val formattedDate = "${localDateTime.month.name.take(3)} ${localDateTime.dayOfMonth}, ${localDateTime.year}"
                Text(text = "Expires: $formattedDate", fontSize = 12.sp, color = MaterialTheme.colorScheme.secondary)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemDialog(
    onDismiss: () -> Unit,
    onConfirm: (String, Double, String) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var unit by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Add New Item") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Item Name") }
                )
                OutlinedTextField(
                    value = quantity,
                    onValueChange = { quantity = it },
                    label = { Text("Quantity") }
                )
                OutlinedTextField(
                    value = unit,
                    onValueChange = { unit = it },
                    label = { Text("Unit (e.g., kg, lbs, items)") }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val quantityValue = quantity.toDoubleOrNull() ?: 0.0
                    if (name.isNotBlank() && quantityValue > 0 && unit.isNotBlank()) {
                        onConfirm(name, quantityValue, unit)
                    }
                }
            ) {
                Text("Add")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}