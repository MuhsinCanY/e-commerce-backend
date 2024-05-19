package com.example.demo.repository;

import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    @Query("select r from Role r where r.authority = :authority")
    Optional<Role> findByAuthority(String authority);

    @Override
    List<Role> findAll();
}
