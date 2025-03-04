package com.productstore.product.service;

import com.productstore.product.dto.ProductDto;
import com.productstore.product.entity.Product;
import com.productstore.product.exceptions.ProductNotFoundException;
import com.productstore.product.repo.ProductRepository;
import com.productstore.product.utils.ProductTypeConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = ProductTypeConversion.productDtoToProduct(productDto);
        productRepository.save(product);
        return ProductTypeConversion.productToProductDto(product);
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto productDto) {
        productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));
        productDto.setProductId(productId);
        Product product = ProductTypeConversion.productDtoToProduct(productDto);
        productRepository.save(product);
        return ProductTypeConversion.productToProductDto(product);
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.delete(productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId)));
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));
        return ProductTypeConversion.productToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (!products.isEmpty()) {
            return products.stream().map(ProductTypeConversion::productToProductDto).toList();
        }
        return List.of();
    }
}
