package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.exceptions.StoreException;
import com.example.demo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findByName(String name) {
        Category category =
                categoryRepository.findByName(name).orElseThrow(
                        () -> new StoreException(
                                "Category not found with given name: " + name,
                                HttpStatus.BAD_REQUEST)
                );
        return category;
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new StoreException("Category not found with given id: " + id,
                        HttpStatus.BAD_REQUEST));
    }

}
