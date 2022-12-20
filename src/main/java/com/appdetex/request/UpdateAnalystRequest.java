package com.appdetex.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
public class UpdateAnalystRequest {

    @Positive (message = "Analyst ID is required")
    private Integer id;
    private String name;
    private String email;
    private String password;
}