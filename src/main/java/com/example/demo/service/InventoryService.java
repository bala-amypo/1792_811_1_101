package com.example.demo.service;

import com.example.demo.entity.Inventory;
import java.util.List;

public interface InventoryService {

    Inventory createInventory(Inventory inventory);

    List<Inventory> getAllInventory();

    Inventory getInventoryById(Long id);

    Inventory updateInventory(Long id, Inventory inventory);

    void deleteInventory(Long id);
}
