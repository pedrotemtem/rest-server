package com.appdetex.rulesengine;

import com.appdetex.entity.Detection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SellerRulesTest {

    @Test
    void checkSellerNameApple() {
        SellerRules brandRules = new SellerRules();
        Detection detection = new Detection();

        detection.setSeller("Apple");
        detection.setDescription("abc");
        detection.setAccountId(2);
        brandRules.checkRules(detection);
        assertEquals("benign", detection.getState());
    }
    @Test
    void checkSellerNameMicrosoft() {
        SellerRules brandRules = new SellerRules();
        Detection detection = new Detection();

        detection.setSeller("Microsoft");
        detection.setDescription("abc");
        detection.setAccountId(3);
        brandRules.checkRules(detection);
        assertEquals("benign", detection.getState());
    }

}