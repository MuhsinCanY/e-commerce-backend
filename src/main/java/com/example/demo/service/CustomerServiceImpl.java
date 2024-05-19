package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Role;
import com.example.demo.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public Customer register(String fullname, String email, String password) {
        Role role = roleService.findByAuthority("USER");

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPassword(passwordEncoder.encode(password));
        customer.setFullName(fullname);
        customer.setAuthorities(roles);

        return customerRepository.save(customer);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
