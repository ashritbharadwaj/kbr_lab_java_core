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

//    @GetMapping("/{transactionId}")
//    public ResponseEntity<TransactionDTO> getTransaction(@PathVariable Long transactionId) {
//        TransactionDTO transaction = transactionService.getTransactionById(transactionId);
//        return ResponseEntity.ok(transaction);
//    }
//
//    @GetMapping("")
//    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
//        List<TransactionDTO> transactions = transactionService.getAllTransactions();
//        return ResponseEntity.ok(transactions);
//    }
//
//    @DeleteMapping("/{transactionId}")
//    public ResponseEntity<Void> deleteTransaction(@PathVariable Long transactionId) {
//        transactionService.deleteTransactionById(transactionId);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PostMapping("")
//    public ResponseEntity<TransactionDTO> addTransaction(@RequestBody @Valid TransactionDTO transaction) {
//        TransactionDTO addedTransaction = transactionService.addTransaction(transaction);
//        return ResponseEntity.created(null).body(addedTransaction);
//    }
//
//    @PutMapping("/{transactionId}")
//    public ResponseEntity<TransactionDTO> updateTransaction(@PathVariable Long transactionId, @RequestBody @Valid TransactionDTO transaction) {
//        TransactionDTO updatedTransaction = transactionService.updateTransaction(transactionId,transaction);
//        return ResponseEntity.accepted().body(updatedTransaction);
//    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long productId) {
        ProductDto product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("")
    public ResponseEntity<ProductDto> addProduct(@RequestBody @Valid ProductDto product) {
        ProductDto addedProduct = productService.addProduct(product);
        return ResponseEntity.created(null).body(addedProduct);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long productId, @RequestBody @Valid ProductDto product) {
        ProductDto updatedProduct = productService.updateProduct(productId,product);
        return ResponseEntity.accepted().body(updatedProduct);
    }

    //Other end-points

}
