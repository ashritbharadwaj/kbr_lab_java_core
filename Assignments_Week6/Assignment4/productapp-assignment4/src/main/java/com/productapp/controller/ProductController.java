package com.productapp.controller;

import com.productapp.repo.Product;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    List<Product> getAllProducts(){
        System.out.println("get all products");
        return productService.getAll();
    }

    @PostMapping("")
    Product saveProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("update/{id}")
    Product updateProduct(@PathVariable String id, @RequestBody Product product){
        return productService.update(id, product);
    }

    @DeleteMapping("delete/{id}")
    void deleteProduct(@PathVariable String id){
        productService.delete(id);
    }

    @GetMapping("{id}")
    Product getProductById(@PathVariable String id){
        return productService.getById(id);
    }
}
