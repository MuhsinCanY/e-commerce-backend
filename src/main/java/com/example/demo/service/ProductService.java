package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    List<Product> findByCategory(Long categoryId);

    List<Product> findByCategoryName(String name);
}
