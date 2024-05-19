package com.example.demo.service;

import com.example.demo.entity.Role;

import java.util.List;

public interface RoleService {

    Role findByAuthority(String authority);

    List<Role> findAll();
}
