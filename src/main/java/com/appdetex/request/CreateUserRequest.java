package com.appdetex.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserRequest {

    private Integer id;
    private String name;
    private String email;
    private String password;
    private Integer roleId;
}
