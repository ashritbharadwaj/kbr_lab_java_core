package com.productapp.service;

import com.productapp.entities.Product;
import com.productapp.repo.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Laptop", 1_00_000);
    }

    @Test
    public void givenProductList_whenGetAll_thenReturnProductList() {
        given(productRepository.findAll()).willReturn(List.of(product,new Product("Mobile", 10_000)));
        assertThat(productService.getAll()).isNotNull();
        assertThat(productService.getAll().size()).isEqualTo(2);
    }

    @Test
    public void givenProductId_whenGetById_thenReturnProduct() {
        given(productRepository.findById(1)).willReturn(Optional.ofNullable(product));
        assertThat(productService.getById(1)).isNotNull();
    }

    @Test
    public void givenProduct_whenAdd_thenReturnProduct() {
        given(productRepository.save(product)).willReturn(product);
        assertThat(productService.add(product)).isNotNull();
    }

    @Test
    public void givenProduct_whenUpdate_thenReturnProduct() {
        given(productRepository.save(product)).willReturn(product);
        assertThat(productService.update(1, product)).isNotNull();
    }

    @Test
    public void givenProductId_whenDelete_thenReturnVoid() {
        productService.delete(1);
        assertThat(productService.getById(1)).isNull();
    }

    @AfterEach
    void tearDown() {
        product = null;
    }
}