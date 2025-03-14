package com.productstore.product.controller;

import com.productstore.product.dto.ProductDto;
import com.productstore.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable String productId) {
        ProductDto product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("")
    public ResponseEntity<ProductDto> addProduct(@RequestBody @Valid ProductDto product) {
        ProductDto addedProduct = productService.addProduct(product);
        return ResponseEntity.created(null).body(addedProduct);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable String productId, @RequestBody @Valid ProductDto product) {
        ProductDto updatedProduct = productService.updateProduct(productId,product);
        return ResponseEntity.accepted().body(updatedProduct);
    }

    //Other end-points

}
