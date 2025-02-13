package com.productapp.service;

import com.productapp.entities.Product;

import java.util.List;

public interface ProductService {
    //CRUD
    public List<Product> getAll();
    public Product getById(int id);
    public Product add(Product product);
    public Product update(int id, Product product);
    public void delete(int id);
}
