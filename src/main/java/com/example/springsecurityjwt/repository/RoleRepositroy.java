package com.example.springsecurityjwt.repository;

import com.example.springsecurityjwt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepositroy extends JpaRepository<Role,Long> {
Role findByName(String name);
}

