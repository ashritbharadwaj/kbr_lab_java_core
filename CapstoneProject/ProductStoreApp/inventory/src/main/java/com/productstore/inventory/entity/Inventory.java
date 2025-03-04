package com.productstore.inventory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeNumber;
    private Integer quantity;

    public Inventory(String codeNumber, Integer quantity) {
        this.codeNumber = codeNumber;
        this.quantity = quantity;
    }
}
