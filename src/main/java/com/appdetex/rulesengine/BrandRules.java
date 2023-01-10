package com.appdetex.rulesengine;

import com.appdetex.entity.Detection;

import java.util.ArrayList;

public class BrandRules implements Rules {

    public BrandRules() {
    }

    ArrayList <String> brandRuleNames = new ArrayList<>();

    @Override
    public Detection checkRules(Detection detection) {

        brandRuleNames.add("Jacuzzi® Brand");
        brandRuleNames.add("Apple®");

        for (String brandName : brandRuleNames) {
            if (detection.getDescription().contains(brandName)) {
                detection.setState("benign");
                detection.setReasonCode("fair-use");
            }
        }

        return detection;
    }
}

