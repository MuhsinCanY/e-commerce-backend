package com.example.demo.service;

import com.example.demo.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();

    Category findByName(String name);

    Category findById(Long id);
}
