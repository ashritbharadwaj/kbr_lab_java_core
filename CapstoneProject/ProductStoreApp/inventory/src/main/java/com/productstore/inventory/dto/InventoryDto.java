package com.productstore.inventory.dto;

import jakarta.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "Code number is required")
    private String codeNumber;

    @NotNull(message = "Quantity is required")
    @Range(min = 1, max = 1000, message = "Quantity must be between 1 and 1000")
    private Integer quantity;

    public InventoryDto(String codeNumber, Integer quantity) {
        this.codeNumber = codeNumber;
        this.quantity = quantity;
    }
}
