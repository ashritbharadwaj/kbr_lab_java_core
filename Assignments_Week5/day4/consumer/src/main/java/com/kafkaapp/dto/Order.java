package com.kafkaapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    //order ID, customer name, product, quantity
    private int orderId;
    private String customerName;
    private String productName;
    private int quantity;
}
