package com.productstore.order.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long orderId;

    @NotNull(message = "ProductId is required")
    private Long productId;

    @NotNull(message = "Quantity is required")
    private Integer quantity;

    private String status;

    private LocalDateTime orderDate;

    private ProductDto productDto;

    public OrderDto(Long productId, Integer quantity, String status, LocalDateTime orderDate) {
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
        this.orderDate = orderDate;
    }

    public OrderDto(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
