package com.example.demo.repository;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    List<Product> findAll();

    @Query("select p from Product p where p.category.id = :category_id")
    List<Product> findByCategory(Long category_id);

    @Query("select p from Product p where p.category.name = :name")
    List<Product> findByCategoryName(String name);
}
