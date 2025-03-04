package com.productstore.inventory.utils;

import com.productstore.inventory.dto.InventoryDto;
import com.productstore.inventory.entity.Inventory;

public class InventoryConversion {
    public static InventoryDto inventoryToInventoryDto(Inventory inventory) {
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setId(inventory.getId());
        inventoryDto.setCodeNumber(inventory.getCodeNumber());
        inventoryDto.setQuantity(inventory.getQuantity());
        return inventoryDto;
    }

    public static Inventory inventoryDtoToInventory(InventoryDto inventoryDto) {
        Inventory inventory = new Inventory();
        inventory.setId(inventoryDto.getId());
        inventory.setCodeNumber(inventoryDto.getCodeNumber());
        inventory.setQuantity(inventoryDto.getQuantity());
        return inventory;
    }
}
