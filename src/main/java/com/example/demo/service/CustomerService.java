package com.example.demo.service;

import com.example.demo.entity.Customer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface CustomerService extends UserDetailsService {
    Customer register(String fullname, String email, String password);

    Customer findById(Long id);
}
