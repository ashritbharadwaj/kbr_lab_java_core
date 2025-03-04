package com.productstore.product.service;

import com.productstore.product.dto.ProductDto;

import java.util.List;

public interface ProductService {
//    public TransactionDTO addTransaction(TransactionDTO transactionDTO);
//
//    public TransactionDTO updateTransaction(Long transactionId,TransactionDTO transactionDTO);
//
//    public void deleteTransactionById(Long transactionId);
//
//    public TransactionDTO getTransactionById(Long transactionId);
//
//    public List<TransactionDTO> getAllTransactions();

    public ProductDto addProduct(ProductDto productDto);

    public ProductDto updateProduct(Long productId,ProductDto productDto);

    public void deleteProductById(Long productId);

    public ProductDto getProductById(Long productId);

    public List<ProductDto> getAllProducts();
}
