package com.appdetex.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateAnalystRequest {

    private Integer id;

    private String name;

    private String email;

    private String password;

}
