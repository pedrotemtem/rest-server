package com.appdetex.response;

import com.appdetex.entity.Analyst;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnalystResponse {

    private Integer id;
    private String name;
    private String email;
    private String password;
    public AnalystResponse (Analyst analyst) {
        this.id = analyst.getId();
        this.name = analyst.getName();
        this.email = analyst.getEmail();
        this.password = analyst.getPassword();
    }
}