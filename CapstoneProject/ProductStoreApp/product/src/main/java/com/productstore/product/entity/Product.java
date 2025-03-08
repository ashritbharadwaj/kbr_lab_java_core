package com.productstore.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long productId;

//    private String codeNumber;
    private String name;
    private double price;
    private String category;
    private String description;

//    public Product(String codeNumber, String name, double price, String category, String description) {
//        this.codeNumber = codeNumber;
//        this.name = name;
//        this.price = price;
//        this.category = category;
//        this.description = description;
//    }


    public Product(String name, double price, String category, String description) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }
}
