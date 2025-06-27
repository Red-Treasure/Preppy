package org.redtreasure.preppy.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import org.redtreasure.preppy.ui.theme.PreppyTheme

@Composable
public fun App() {
    PreppyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val inventoryViewModel: InventoryViewModel = viewModel(factory = ViewModelFactory)
            InventoryScreen(viewModel = inventoryViewModel)
        }
    }
}