package com.appdetex.service;

import com.appdetex.entity.Analyst;
import com.appdetex.entity.MarketplaceDetection;
import com.appdetex.repository.AccountRepository;
import com.appdetex.entity.Account;
import com.appdetex.repository.AnalystRepository;
import com.appdetex.request.CreateAccountRequest;
import com.appdetex.request.CreateAnalystRequest;
import com.appdetex.response.AccountResponse;

import com.appdetex.response.MarketplaceDetectionResponse;
import com.fasterxml.jackson.core.type.TypeReference;
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

    public String getAccountNameByDetectionId(int detection_id) throws IOException {

        // gets the detection with id detection_id
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8008/api/marketplacedetections/getById/"+ detection_id);
        CloseableHttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        String responseDetection = EntityUtils.toString(entity);

        // converts the json string response to a MarketplaceDetection object
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MarketplaceDetection detection = mapper.readValue(responseDetection, MarketplaceDetection.class);

        int accountId = detection.getAccountId();

        request = new HttpGet("http://localhost:8008/api/account/getAccountName/"+ accountId);
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

    public String getAccountNameById(int account_id) {

        Account account = accountRepository.findById(account_id);

        String accountName = account.getName();

        return accountName;
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
