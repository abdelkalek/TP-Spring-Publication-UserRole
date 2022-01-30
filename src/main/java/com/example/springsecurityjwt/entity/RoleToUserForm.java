package com.example.springsecurityjwt.entity;

import lombok.Data;

@Data
public class RoleToUserForm {
    private String username;
    private String roleName;
}
