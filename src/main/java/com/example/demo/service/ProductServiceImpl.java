package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.util.StoreValidation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByCategory(Long categoryId) {
        StoreValidation.checkId(categoryId);
        return productRepository.findByCategory(categoryId);
    }

    @Override
    public List<Product> findByCategoryName(String name) {
        StoreValidation.checkName(name);
        return productRepository.findByCategoryName(name);
    }


}
