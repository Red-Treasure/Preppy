package org.redtreasure.preppy

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.redtreasure.preppy.ui.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Preppy",
    ) {
        App()
    }
}