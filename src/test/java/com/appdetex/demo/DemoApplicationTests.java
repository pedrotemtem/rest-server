package com.appdetex.demo;

import com.appdetex.controller.*;
import com.appdetex.repository.AuditRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	AccountController accountController;

	@Autowired
	AuditController auditController;

	@Autowired
	BrandTrackController brandTrackController;

	@Autowired
	DetectionController detectionController;

	@Autowired
	RoleController roleController;

	@Autowired
	UserController userController;

	@Test
	public void contextLoads() {
		Assertions.assertThat(auditController).isNotNull();
	}

	@Test
	public void contextLoads2(){
		Assertions.assertThat(accountController).isNotNull();
	}

}
