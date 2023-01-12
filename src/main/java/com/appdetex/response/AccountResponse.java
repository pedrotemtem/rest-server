package com.appdetex.response;

import com.appdetex.entity.Account;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountResponse {

    private int id;
    private String name;
    public AccountResponse (Account account) {
        this.id = account.getId();
        this.name = account.getName();
    }
}
