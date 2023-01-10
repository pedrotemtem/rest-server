package com.appdetex.controller;

import com.appdetex.request.CreateAccountRequest;
import com.appdetex.response.AccountResponse;
import com.appdetex.service.AccountService;
import com.appdetex.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/api/accounts/")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("")
    public List<AccountResponse> getAllAccounts() {

        List<Account> accountList = accountService.getAllAccounts();
        List<AccountResponse> accountResponseList = new ArrayList<AccountResponse>();

        accountList.stream().forEach(account -> {
            accountResponseList.add(new AccountResponse(account));
        });

        return accountResponseList;
    }

    @GetMapping("detection/{detectionId}")
    public String getAccountNameByDetectionId(@PathVariable int detectionId) throws IOException {

        return accountService.getAccountNameByDetectionId(detectionId);
    }

    @GetMapping("{accountId}")
    public String getAccountName(@PathVariable int accountId) {

        return accountService.getAccountNameByAccountId(accountId);
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
