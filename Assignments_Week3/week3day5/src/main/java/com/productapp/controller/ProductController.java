package com.productapp.controller;

import com.productapp.entities.Product;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "productsorted")
    public List<Product> getAllProductSorted(@RequestParam(name="field") String field) {
        return productService.getAllProductSorted(field);
    }

    @GetMapping(path = "productpage")
    public Page<Product> getAllProductPage(@RequestParam(name="offset") int offset, @RequestParam(name="pageSize") int pageSize) {
        return productService.getAllProductPage(offset, pageSize);
    }

    @GetMapping(path = "productpagesorted")
    public Page<Product> getAllProductPageSorted(@RequestParam(name="offset") int offset, @RequestParam(name="pageSize") int pageSize, @RequestParam(name="field") String field) {
        return productService.getAllProductPageSorted(field, offset, pageSize);
    }
}