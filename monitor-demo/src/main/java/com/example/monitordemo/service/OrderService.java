package com.example.monitordemo.service;

import com.example.monitordemo.model.Order;
import com.example.monitordemo.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        log.info("Creating new order: {}", order.getOrderNumber());

        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());
        order.setStatus("CREATED");

        Order savedOrder = orderRepository.save(order);
        log.info("Order created successfully, ID: {}", savedOrder.getId());

        return savedOrder;
    }

    public Optional<Order> getOrder(Long id) {
        log.debug("Getting order by ID: {}", id);
        return orderRepository.findById(id);
    }

    public List<Order> getAllOrders() {
        log.debug("Getting all orders list");
        return orderRepository.findAll();
    }

    public Optional<Order> updateStatus(Long id, String newStatus) {
        log.info("Updating order {} status to: {}", id, newStatus);

        return orderRepository.findById(id)
                .map(order -> {
                    order.setStatus(newStatus);
                    order.setUpdatedAt(LocalDateTime.now());
                    orderRepository.save(order);
                    log.info("Order {} status updated successfully", id);
                    return order;
                });
    }

    public boolean deleteOrder(Long id) {
        log.info("Deleting order with ID: {}", id);

        if (orderRepository.existsById(id)) {
            orderRepository.delete(id);
            log.info("Order with ID {} deleted successfully", id);
            return true;
        }

        log.warn("Order with ID {} not found for deletion", id);
        return false;
    }

    public long getOrdersCount() {
        return orderRepository.count();
    }

}
