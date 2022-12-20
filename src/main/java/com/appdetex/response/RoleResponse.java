package com.appdetex.response;

import com.appdetex.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleResponse {

    private Integer id;
    private String role;
    public RoleResponse (Role role) {
        this.id = role.getId();
        this.role = role.getRole();
    }
}
