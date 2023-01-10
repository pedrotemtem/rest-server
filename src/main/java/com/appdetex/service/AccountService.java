package com.appdetex.service;

import com.appdetex.entity.Detection;
import com.appdetex.repository.AccountRepository;
import com.appdetex.entity.Account;
import com.appdetex.repository.DetectionRepository;
import com.appdetex.request.CreateAccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    private DetectionRepository detectionRepository;

    public String getAccountNameByDetectionId(int detectionId) {

        Detection detection = detectionRepository.findById(detectionId);
        int accountId = detection.getAccountId();
        Account account = accountRepository.findById(accountId);
        return account.getName();
    }

    public List<Account> getAllAccounts() {

        return accountRepository.findAll();
    }

    public String getAccountNameByAccountId(int accountId) {

        Account account = accountRepository.findById(accountId);
        return account.getName();
    }

    public Account createAccount (CreateAccountRequest createAccountRequest) {

        Account account = new Account(createAccountRequest);
        return accountRepository.save(account);
    }

    public String deleteAccount (int id) {

        accountRepository.deleteById(id);
        return "Account has been deleted successfully";
    }
}