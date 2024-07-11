package eshop.service.impl;

import eshop.domain.Order;
import eshop.domain.OrderRepository;
import eshop.domain.PlaceorderCommand;
import eshop.service.OrderService;
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

@Service("orderService")
@Transactional
public class OrderServiceImpl
    extends EgovAbstractServiceImpl
    implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        OrderServiceImpl.class
    );

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() throws Exception {
        // Get all orders
        return StreamSupport
            .stream(orderRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Order> getOrderById(Long id) throws Exception {
        // Get a order by ID
        return orderRepository.findById(id);
    }

    @Override
    public Order createOrder(Order order) throws Exception {
        // Create a new order
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) throws Exception {
        // Update an existing order via OrderService
        if (orderRepository.existsById(order.getId())) {
            return orderRepository.save(order);
        } else {
            throw processException("info.nodata.msg");
        }
    }

    @Override
    public void deleteOrder(Long id) throws Exception {
        // Delete a order
        orderRepository.deleteById(id);
    }

    @Override
    public Order placeorder(PlaceorderCommand placeorderCommand)
        throws Exception {
        // You can implement logic here, or call the domain method of the Order.
        Order order = new Order();
        order.placeorder(placeorderCommand);
        orderRepository.save(order);
        /** Option 1-1:  implement logic here 
        Optional<Order> optionalOrder = orderRepository.findById(placeorderCommand.getOrderId());

        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.placeorder(placeorderCommand);
            return orderRepository.save(order);
        } else {
            throw processException("info.nodata.msg");
        }
        */
    }
}
