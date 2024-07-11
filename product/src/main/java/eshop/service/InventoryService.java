package eshop.service;

import eshop.domain.*;
import java.util.List;
import java.util.Optional;

public interface InventoryService {
    List<Inventory> getAllInventories() throws Exception;
    Optional<Inventory> getInventoryById(Long id) throws Exception;
    Inventory createInventory(Inventory inventory) throws Exception;
    Inventory updateInventory(Inventory inventory) throws Exception;
    void deleteInventory(Long id) throws Exception;
}
