package com.example.monitordemo.controller;

import com.example.monitordemo.dto.CreateOrderRequest;
import com.example.monitordemo.dto.OrderResponse;
import com.example.monitordemo.model.Order;
import com.example.monitordemo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderRequest request) {
        log.info("Received request to create order: {}", request.getOrderNumber());

        try {
            Order order = new Order();
            order.setOrderNumber(request.getOrderNumber());
            order.setAmount(request.getAmount());

            Order createdOrder = orderService.createOrder(order);
            OrderResponse response = convertToResponse(createdOrder);

            log.info("Order created successfully: {}", createdOrder.getId());
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            log.error("Error creating order: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
        log.debug("Received request to get order with ID: {}", id);

        return orderService.getOrder(id)
                .map(order -> {
                    OrderResponse response = convertToResponse(order);
                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        log.debug("Received request to get all orders");

        List<OrderResponse> orders = orderService.getAllOrders().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<OrderResponse> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        log.info("Received request to update order {} status to: {}", id, status);

        return orderService.updateStatus(id, status)
                .map(order -> {
                    OrderResponse response = convertToResponse(order);
                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        log.info("Received request to delete order with ID: {}", id);

        boolean deleted = orderService.deleteOrder(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/statistics")
    public ResponseEntity<Statistics> getStatistics() {
        log.debug("Received request to get orders statistics");

        long ordersCount = orderService.getOrdersCount();
        Statistics statistics = new Statistics(ordersCount);

        return ResponseEntity.ok(statistics);
    }

    private OrderResponse convertToResponse(Order order) {
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setOrderNumber(order.getOrderNumber());
        response.setStatus(order.getStatus());
        response.setAmount(order.getAmount());
        response.setCreatedAt(order.getCreatedAt().format(dateFormatter));
        return response;
    }

    public record Statistics(long ordersCount) {
    }

}
