package org.redtreasure.preppy.data

data class InventoryItem(
    val id: Int = 0,
    val name: String,
    val quantity: Double,
    val unit: String,
    val expiryDate: Long? = null // Storing as Long (timestamp)
)