package com.example.demo.repository;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    List<Product> findAll();

    @Override
    Optional<Product> findById(Long aLong);

    @Query("select p from Product p where p.category.id = :category_id")
    List<Product> findByCategory(Long category_id);

    @Query("select p from Product p where p.category.name = :name")
    List<Product> findByCategoryName(String name);
}
