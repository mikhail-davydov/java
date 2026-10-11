package com.example.monitordemo.component;

import com.example.monitordemo.model.Order;
import com.example.monitordemo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

    private final OrderService orderService;

    @Autowired
    public DataInitializer(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Initializing demo data...");

        // Create test orders
        Order order1 = new Order();
        order1.setOrderNumber("ORD-001");
        order1.setAmount(new BigDecimal("1500.50"));
        orderService.createOrder(order1);

        Order order2 = new Order();
        order2.setOrderNumber("ORD-002");
        order2.setAmount(new BigDecimal("2750.00"));
        orderService.createOrder(order2);

        Order order3 = new Order();
        order3.setOrderNumber("ORD-003");
        order3.setAmount(new BigDecimal("980.75"));
        orderService.createOrder(order3);

        log.info("Demo data created successfully");
    }

}
