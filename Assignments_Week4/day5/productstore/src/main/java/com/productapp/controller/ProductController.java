package com.productapp.controller;


import com.productapp.entities.Product;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    List<Product> getAll() {return productService.getAll();}

    @GetMapping("/products/{id}")
    Product getById(@PathVariable int id) {return productService.getById(id);}

    @PostMapping("/add")
    Product add(@RequestBody Product product) {return productService.add(product);}

    @PutMapping("/update/{id}")
    Product update(@PathVariable int id, @RequestBody Product product) {return productService.update(id,product);}

    @GetMapping("/delete/{id}")
    String delete(@PathVariable int id) {
        productService.delete(id);
        return "Deleted";
    }
}
