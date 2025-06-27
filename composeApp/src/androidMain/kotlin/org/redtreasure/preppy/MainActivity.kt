package org.redtreasure.preppy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.redtreasure.preppy.ui.App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // The App Composable is now the main entry point, defined in commonMain
            App()
        }
    }
}