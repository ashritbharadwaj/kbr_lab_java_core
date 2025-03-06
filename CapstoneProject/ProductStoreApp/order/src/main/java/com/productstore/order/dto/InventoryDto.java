package com.productstore.order.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDto {

    private Long id;

    @NotNull(message = "Product ID is required")
    private Long productId;

    @NotNull(message = "Quantity is required")
    @Range(min = 1, max = 1000, message = "Quantity must be between 1 and 1000")
    private Integer quantity;

    public InventoryDto(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
