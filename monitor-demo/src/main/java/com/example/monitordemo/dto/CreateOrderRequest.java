package com.example.monitordemo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateOrderRequest {

    private String orderNumber;
    private BigDecimal amount;

}
