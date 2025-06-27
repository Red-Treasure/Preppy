package org.redtreasure.preppy.ui

import androidx.lifecycle.ViewModelProvider
import org.redtreasure.preppy.data.InventoryRepository

/**
 * An 'expect' factory that declares the existence of a ViewModelProvider.Factory.
 * Each platform will provide its own 'actual' implementation.
 */
expect object ViewModelFactory : ViewModelProvider.Factory