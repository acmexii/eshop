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
// @RequestMapping(value="/orders")
public class OrderController {

    @Resource(name = "orderService")
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getAllOrders() throws Exception {
        // Get all orders via OrderService
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id)
        throws Exception {
        // Get a order by ID via OrderService
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) throws Exception {
        // Create a new order via OrderService
        return orderService.createOrder(order);
    }

    @PutMapping("/orders/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order)
        throws Exception {
        // Update an existing order via OrderService
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Long id) throws Exception {
        // Delete a order via OrderService
        orderService.deleteOrder(id);
    }

    @RequestMapping(
        value = "/orders/placeorder",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Order placeorder(
        @RequestBody PlaceorderCommand placeorderCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        return orderService.placeorder(placeorderCommand);
    }
}
