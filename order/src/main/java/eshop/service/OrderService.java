package eshop.service;

import eshop.domain.*;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrders() throws Exception;
    Optional<Order> getOrderById(Long id) throws Exception;
    Order createOrder(Order order) throws Exception;
    Order updateOrder(Order order) throws Exception;
    void deleteOrder(Long id) throws Exception;

    Order placeorder(PlaceorderCommand placeorderCommand) throws Exception;
}
