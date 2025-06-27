package org.redtreasure.preppy.data

fun InventoryItemEntity.toDomain(): InventoryItem {
    return InventoryItem(id = this.id, name = this.name, quantity = this.quantity, unit = this.unit, expiryDate = this.expiryDate)
}

fun InventoryItem.toEntity(): InventoryItemEntity {
    return InventoryItemEntity(id = this.id, name = this.name, quantity = this.quantity, unit = this.unit, expiryDate = this.expiryDate)
}