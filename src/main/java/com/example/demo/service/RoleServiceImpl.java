package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.exceptions.StoreException;
import com.example.demo.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    RoleRepository roleRepository;

    public Role findByAuthority(String authority) {
        return roleRepository.findByAuthority(authority)
                .orElseThrow(() -> new StoreException("Authority not found with given input: " + authority,
                        HttpStatus.BAD_REQUEST));
    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

}
