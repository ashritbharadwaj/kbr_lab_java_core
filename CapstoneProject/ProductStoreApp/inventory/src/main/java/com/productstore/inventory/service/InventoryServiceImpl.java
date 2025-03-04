package com.productstore.inventory.service;

import com.productstore.inventory.dto.InventoryDto;
import com.productstore.inventory.entity.Inventory;
import com.productstore.inventory.exceptions.InventoryNotFoundException;
import com.productstore.inventory.repo.InventoryRepository;
import com.productstore.inventory.utils.InventoryConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public InventoryDto addInventory(InventoryDto inventoryDto) {
        Inventory inventory = InventoryConversion.inventoryDtoToInventory(inventoryDto);
        inventoryRepository.save(inventory);
        return InventoryConversion.inventoryToInventoryDto(inventory);
    }

    @Override
    public InventoryDto updateInventory(Long inventoryId, InventoryDto inventoryDto) {
        Inventory inventory = inventoryRepository.findById(inventoryId).orElseThrow(() -> new InventoryNotFoundException("Inventory not found with id: " + inventoryId));

        inventory.setCodeNumber(inventoryDto.getCodeNumber());
        inventory.setQuantity(inventoryDto.getQuantity());
        inventoryRepository.save(inventory);

        return InventoryConversion.inventoryToInventoryDto(inventory);
    }

    @Override
    public void deleteInventoryById(Long inventoryId) {
        inventoryRepository.deleteById(inventoryId);
    }

    @Override
    public InventoryDto getInventoryById(Long inventoryId) {
        Inventory inventory = inventoryRepository.findById(inventoryId).orElseThrow(() -> new InventoryNotFoundException("Inventory not found with id: " + inventoryId));
        return InventoryConversion.inventoryToInventoryDto(inventory);
    }

    @Override
    public List<InventoryDto> getAllInventories() {
        List<Inventory> inventories = inventoryRepository.findAll();
        return inventories.stream().map(InventoryConversion::inventoryToInventoryDto).toList();
    }
}
