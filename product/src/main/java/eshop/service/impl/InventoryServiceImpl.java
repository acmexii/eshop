package eshop.service.impl;

import eshop.domain.Inventory;
import eshop.domain.InventoryRepository;
import eshop.service.InventoryService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("inventoryService")
@Transactional
public class InventoryServiceImpl
    extends EgovAbstractServiceImpl
    implements InventoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        InventoryServiceImpl.class
    );

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> getAllInventories() throws Exception {
        // Get all inventories
        return StreamSupport
            .stream(inventoryRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Inventory> getInventoryById(Long id) throws Exception {
        // Get a inventory by ID
        return inventoryRepository.findById(id);
    }

    @Override
    public Inventory createInventory(Inventory inventory) throws Exception {
        // Create a new inventory
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory updateInventory(Inventory inventory) throws Exception {
        // Update an existing inventory via InventoryService
        if (inventoryRepository.existsById(inventory.getId())) {
            return inventoryRepository.save(inventory);
        } else {
            throw processException("info.nodata.msg");
        }
    }

    @Override
    public void deleteInventory(Long id) throws Exception {
        // Delete a inventory
        inventoryRepository.deleteById(id);
    }
}
