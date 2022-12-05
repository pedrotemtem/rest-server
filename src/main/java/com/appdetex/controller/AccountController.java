package com.appdetex.controller;

import com.appdetex.request.CreateAccountRequest;
import com.appdetex.response.AccountResponse;
import com.appdetex.service.AccountService;
import com.appdetex.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/accounts/")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("getAll")
    public List<AccountResponse> getAllAccounts() {
        List<Account> accountList = accountService.getAllAccounts();
        List<AccountResponse> accountResponseList = new ArrayList<AccountResponse>();

        accountList.stream().forEach(account -> {
            accountResponseList.add(new AccountResponse(account));
        });

        return accountResponseList;
    }

    @PostMapping("create")
    public AccountResponse createAccount(@RequestBody CreateAccountRequest createAccountRequest){
        Account account = accountService.createAccount(createAccountRequest);

        return new AccountResponse(account);
    }

    @DeleteMapping("delete/{id}")
    public String deleteAccount(@PathVariable int id){
        return accountService.deleteAccount(id);
    }

}
