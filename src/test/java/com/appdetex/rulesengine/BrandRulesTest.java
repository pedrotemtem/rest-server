package com.appdetex.rulesengine;

import com.appdetex.entity.Detection;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


class BrandRulesTest {

    @Test
    void checkBrandRules() {
        BrandRules brandRules = new BrandRules();
        Detection detection = new Detection();

        detection.setDescription("Jacuzzi® Brand");
        detection.setAccountId(3);
        brandRules.checkRules(detection);
        assertEquals("benign", detection.getState());
    }
}