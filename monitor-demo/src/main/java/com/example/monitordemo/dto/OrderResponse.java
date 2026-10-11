package com.example.monitordemo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderResponse {

    private Long id;
    private String orderNumber;
    private String status;
    private BigDecimal amount;
    private String createdAt;

}
