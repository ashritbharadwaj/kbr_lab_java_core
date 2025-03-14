package com.productapp.service;

import com.productapp.entities.Product;
import com.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Override
    public List<Product> getAllProductSorted(String field) {
        return productRepo.findAll(Sort.by(Sort.Direction.DESC, field));
    }

    @Override
    public Page<Product> getAllProductPage(int offset, int pageSize) {
        return productRepo.findAll(PageRequest.of(offset, pageSize));
    }

    @Override
    public Page<Product> getAllProductPageSorted(String field, int offset, int pageSize) {
        return productRepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
    }
}
