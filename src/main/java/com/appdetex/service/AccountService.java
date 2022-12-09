package com.appdetex.service;

import com.appdetex.entity.Analyst;
import com.appdetex.repository.AccountRepository;
import com.appdetex.entity.Account;
import com.appdetex.repository.AnalystRepository;
import com.appdetex.request.CreateAccountRequest;
import com.appdetex.request.CreateAnalystRequest;
import com.appdetex.response.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account createAccount (CreateAccountRequest createAccountRequest){
        Account account = new Account(createAccountRequest);
        account = accountRepository.save(account);
        return account;
    }

    //get account by account-id da detection
    public String deleteAccount (int id){
        accountRepository.deleteById(id);
        return "Account has been deleted successfully";
    }
}
