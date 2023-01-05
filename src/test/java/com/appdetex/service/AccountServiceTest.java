package com.appdetex.service;

import com.appdetex.entity.Account;
import com.appdetex.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AccountServiceTest {

    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;


    private Account account;

    @Autowired
    MockMvc mockMvc;



    @BeforeEach
    public void setup(){
        accountRepository = Mockito.mock(AccountRepository.class);
        account.setId(1);
        account.setName("John");
        accountRepository.save(account);
    }

    @DisplayName("Single test to get detection by id")
    @Test
    void getAccountNameByDetectionId() {


    }

    @Disabled("Not implemented yet")
    @Test
    void getAllAccounts() {
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