package com.example.demo.service;

import com.example.demo.dto.CartPostDTO;
import com.example.demo.entity.Cart;

import java.util.List;

public interface CartService {

    List<Cart> findAll();

    Cart findById(Long id);

    List<Cart> findByCustomer(String name);

    Cart saveByCustomer(CartPostDTO cartPostDTO);

    Cart update(Long cartId, CartPostDTO cartPostDTO);

    Cart delete(Long id);
}
