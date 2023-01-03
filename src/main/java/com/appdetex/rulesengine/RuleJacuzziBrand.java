package com.appdetex.rulesengine;

import com.appdetex.entity.Detection;

public class RuleJacuzziBrand implements RulesInterface{

    public RuleJacuzziBrand() {
    }

    @Override
    public Detection rulesChecker(Detection detection) {

        if (detection.getAccountId() == 1) {
            if (detection.getDescription().contains("Jacuzzi® Brand")) {
                detection.setState("benign");
                detection.setReasonCode("fair-use");
            }
        }

        return detection;
    }
}

