package com.example.demo.repository;

import com.example.demo.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {
    @Override
    List<Cart> findAll();

    @Query("select c from Cart c where c.customer.id = :customer_id")
    List<Cart> findByCustomer(Long customer_id);

    @Override
    Optional<Cart> findById(Long aLong);

    @Override
    void delete(Cart entity);
}
