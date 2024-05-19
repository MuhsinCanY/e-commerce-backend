package com.example.demo.controller;

import com.example.demo.dto.CustomerRegister;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/register")
    public Customer register(@RequestBody CustomerRegister customerRegister) {
        return customerService.register(customerRegister.fullName(), customerRegister.email(),
                customerRegister.password());
    }
}
