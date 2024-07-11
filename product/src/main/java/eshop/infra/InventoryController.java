package eshop.infra;

import eshop.domain.*;
import eshop.service.*;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/inventories")
public class InventoryController {

    @Resource(name = "inventoryService")
    private InventoryService inventoryService;

    @GetMapping("/inventories")
    public List<Inventory> getAllInventories() throws Exception {
        // Get all inventories via InventoryService
        return inventoryService.getAllInventories();
    }

    @GetMapping("/inventories/{id}")
    public Optional<Inventory> getInventoryById(@PathVariable Long id)
        throws Exception {
        // Get a inventory by ID via InventoryService
        return inventoryService.getInventoryById(id);
    }

    @PostMapping("/inventories")
    public Inventory createInventory(@RequestBody Inventory inventory)
        throws Exception {
        // Create a new inventory via InventoryService
        return inventoryService.createInventory(inventory);
    }

    @PutMapping("/inventories/{id}")
    public Inventory updateInventory(
        @PathVariable Long id,
        @RequestBody Inventory inventory
    ) throws Exception {
        // Update an existing inventory via InventoryService
        return inventoryService.updateInventory(inventory);
    }

    @DeleteMapping("/inventories/{id}")
    public void deleteInventory(@PathVariable Long id) throws Exception {
        // Delete a inventory via InventoryService
        inventoryService.deleteInventory(id);
    }
}
