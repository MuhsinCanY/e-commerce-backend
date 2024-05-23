package com.example.demo.service;

import com.example.demo.dto.CartPostDTO;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;
import com.example.demo.exceptions.StoreException;
import com.example.demo.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CustomerService customerService;
    private ProductService productService;

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findById(Long id) {
        return cartRepository.findById(id).orElseThrow(() -> new StoreException("Cart not found " +
                "with given ID", HttpStatus.BAD_REQUEST));
    }

    @Override
    public List<Cart> findByCustomer(String name) {
        Customer customer = (Customer) customerService.loadUserByUsername(name);
        return cartRepository.findByCustomer(customer.getId());
    }

    public Cart saveByCustomer(CartPostDTO cartPostDTO) {
        Cart cart = new Cart();
        UserDetails userDetails = customerService.loadUserByUsername(cartPostDTO.customerName());
        Product product = productService.findById(cartPostDTO.productId());

        cart.setCustomer((Customer) userDetails);
        cart.setProduct(product);
        cart.setCount(cartPostDTO.count());
        return cartRepository.save(cart);
    }

    public Cart update(Long cartId, CartPostDTO cartPostDTO) {
        Cart cart = findById(cartId);
        cart.setCount(cartPostDTO.count());
        return cartRepository.save(cart);
    }

    @Override
    public Cart delete(Long id) {
        Cart cart = findById(id);
        cartRepository.delete(cart);
        return cart;
    }

}
