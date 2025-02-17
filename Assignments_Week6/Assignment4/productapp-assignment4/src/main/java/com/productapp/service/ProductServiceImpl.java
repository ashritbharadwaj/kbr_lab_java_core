package com.productapp.service;

import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product save(Product book) {
        productRepo.save(book);
        return book;
    }

    @Override
    public Product update(String id, Product book) {
        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(book.getName());
        product.setQty(book.getQty());
        product.setVendor(book.getVendor());
        product.setCost(book.getCost());
        productRepo.save(product);
        return product;
    }

    @Override
    public void delete(String id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product getById(String id) {
        return productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
