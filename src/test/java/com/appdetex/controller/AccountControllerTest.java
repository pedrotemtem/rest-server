package com.appdetex.controller;

import com.appdetex.demo.DemoApplication;
import com.appdetex.entity.Detection;
import com.appdetex.service.AccountService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {AccountController.class})
@WebMvcTest
class AccountControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    AccountService accountService;

    Detection detection =new Detection();

    @Test
    void getAllAccounts() throws Exception {
        assert(accountService).getAllAccounts().isEmpty();

    }

    @Disabled("Not implemented yet")
    @Test
    void getAccountNameByDetectionId() throws Exception {

    }

    @Disabled("Not implemented yet")
    @Test
    void getAccountName() {
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