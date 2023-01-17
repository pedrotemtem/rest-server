package com.appdetex.service;

import com.appdetex.entity.Account;
import com.appdetex.entity.Detection;
import com.appdetex.repository.AccountRepository;
import com.appdetex.repository.DetectionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private Account account;

    @Mock
    private Detection detection;

    @Mock
    private DetectionRepository detectionRepository;


    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);

        detection.setId(20);
        detection.setTitle("Abc");
        detection.setDescription("abc");
        detection.setAccountId(30);
        detectionRepository.save(detection);

        account.setName("TestAccount");
        account.setId(30);
        accountRepository.save(account);

    }

    @DisplayName("Test to get AccountName by DetectionId")
    @Test
    void getAccountNameByDetectionId() {


        detection = detectionRepository.findById(20);
        int accountId = detection.getAccountId();
         account= accountRepository.findById(accountId);
        assertEquals("TestAccount",account.getName());

    }

    //@Disabled("Not implemented yet")
    @Test
    void getAllAccounts() {

        account.setId(1);
        account.setName("John");
        accountRepository.save(account);

        //given(accountRepository.save(account)).willReturn(account);
        assertEquals(30, account.getId());
    }

    @Disabled("Not implemented yet")
    @Test
    void getAccountNameByAccountId() {
    }

    @Disabled("Not implemented yet")
    @Test
    void createAccount() {
    }

    @Disabled("Not implemented yet")
    @Test
    void deleteAccount() {
    }
}