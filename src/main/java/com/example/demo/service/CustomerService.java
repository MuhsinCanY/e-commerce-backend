package com.example.demo.service;

import com.example.demo.entity.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomerService extends UserDetailsService {

    Customer register(String fullname, String email, String password);
}
