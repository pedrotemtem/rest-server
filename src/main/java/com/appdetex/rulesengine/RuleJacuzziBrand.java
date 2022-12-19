package com.appdetex.rulesengine;

import com.appdetex.entity.MarketplaceDetection;

public class RuleJacuzziBrand extends RulesAbstract implements RulesInterface{

    public RuleJacuzziBrand() {
    }

    @Override
    public MarketplaceDetection rulesChecker(MarketplaceDetection marketplaceDetection) {
        if (marketplaceDetection.getAccountId() == 1) {
            if (marketplaceDetection.getDescription().contains("Jacuzzi® Brand")) {
                marketplaceDetection.setState("benign");
                marketplaceDetection.setReasonCode("fair-use");
            }
        }

        return marketplaceDetection;
    }
}

