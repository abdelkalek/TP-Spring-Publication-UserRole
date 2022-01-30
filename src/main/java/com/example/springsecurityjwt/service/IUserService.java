package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.entity.Role;
import com.example.springsecurityjwt.entity.User;

import java.util.List;

public interface IUserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
