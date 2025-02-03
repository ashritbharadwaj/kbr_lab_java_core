package com.bankapp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDto {
    private int fromId;
    private int toId;

    @NotNull(message = "Amount cannot be null")
    @Range(min = 10, max=100000, message = "Amount must be in range 10 to 100000")
    private BigDecimal amount;
}
