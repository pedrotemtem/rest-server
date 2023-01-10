package com.appdetex.rulesengine;

import com.appdetex.entity.Detection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InflatableJacuzziRuleTest {

    @Test
    void checkDescriptionJacuzzi() {
        InflatableJacuzziRule brandRules = new InflatableJacuzziRule();
        Detection detection = new Detection();

        detection.setTitle("abc");
        detection.setDescription("inflable");
        detection.setAccountId(1);
        brandRules.checkRules(detection);
        assertEquals("enforce", detection.getState());
    }

    @Test
    void checkTitleJacuzzi() {
        InflatableJacuzziRule brandRules = new InflatableJacuzziRule();
        Detection detection = new Detection();

        detection.setTitle("inflatable");
        detection.setDescription("abc");
        detection.setAccountId(1);
        brandRules.checkRules(detection);
        assertEquals("enforce", detection.getState());
    }


}