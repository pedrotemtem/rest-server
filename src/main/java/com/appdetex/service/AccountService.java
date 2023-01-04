package com.appdetex.service;

import com.appdetex.entity.Detection;
import com.appdetex.repository.AccountRepository;
import com.appdetex.entity.Account;
import com.appdetex.request.CreateAccountRequest;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AccountService {

    @Autowired
     AccountRepository accountRepository;

    public String getAccountNameByDetectionId(int detectionId) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8008/api/marketplacedetections/getById/"+ detectionId);
        CloseableHttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        String responseDetection = EntityUtils.toString(entity);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Detection detection = mapper.readValue(responseDetection, Detection.class);

        request = new HttpGet("http://localhost:8008/api/account/getAccountName/"+ detection.getAccountId());
        response = httpClient.execute(request);
        entity = response.getEntity();
        String accountName = EntityUtils.toString(entity);

        response.close();
        httpClient.close();
        return accountName;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public String getAccountNameByAccountId(int accountId) {

        Account account = accountRepository.findById(accountId);
        String accountName = account.getName();
        return accountName;
    }

    public Account createAccount (CreateAccountRequest createAccountRequest){

        Account account = new Account(createAccountRequest);
        account = accountRepository.save(account);
        return account;
    }

    public String deleteAccount (int id){

        accountRepository.deleteById(id);
        return "Account has been deleted successfully";
    }
}