package com.appdetex.rulesengine;

import com.appdetex.entity.Detection;

public class JacuzziBrandRule implements DetectionRule {

    public JacuzziBrandRule() {
    }

    @Override
    public Detection checkRule(Detection detection) {

        if (detection.getAccountId() == 1) {
            if (detection.getDescription().contains("Jacuzzi® Brand")) {
                detection.setState("benign");
                detection.setReasonCode("fair-use");
            }
        }

        return detection;
    }
}

