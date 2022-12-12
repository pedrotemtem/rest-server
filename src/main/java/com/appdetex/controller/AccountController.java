package com.appdetex.controller;

import com.appdetex.request.CreateAccountRequest;
import com.appdetex.response.AccountResponse;
import com.appdetex.service.AccountService;
import com.appdetex.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/account/")
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

    @GetMapping("getAccountNameByDetectionId/{detection_id}")
    public String getAccountNameByDetectionId(@PathVariable int detection_id) throws IOException {
        return accountService.getAccountNameByDetectionId(detection_id);
    }

    @GetMapping("getAccountName/{account_id}")
    public String getAccountName(@PathVariable int account_id) {;
        return accountService.getAccountNameById(account_id);
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
