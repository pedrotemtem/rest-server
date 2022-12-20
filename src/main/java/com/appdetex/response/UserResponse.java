package com.appdetex.response;

import com.appdetex.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private Integer id;
    private String name;
    private String email;
    private String password;
    private Integer rolesId;
    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.rolesId = user.getRolesId();
    }
}