package com.example.demo.controller;


import com.example.demo.dto.CartPostDTO;
import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @GetMapping
    public List<Cart> findAll() {
        return cartService.findAll();
    }

    @GetMapping("/customer/{name}")
    public List<Cart> findByUser(@PathVariable String name) {
        return cartService.findByCustomer(name);
    }

    @PostMapping("/save")
    public Cart save(@RequestBody CartPostDTO cartPostDTO) {
        return cartService.saveByCustomer(cartPostDTO);
    }

    @PutMapping("/update/{cartId}")
    public Cart update(@PathVariable Long cartId, @RequestBody CartPostDTO cartPostDTO) {
        return cartService.update(cartId, cartPostDTO);
    }

    @DeleteMapping("delete/{id}")
    public  Cart delete(@PathVariable Long id){
        return cartService.delete(id);
    }

}
