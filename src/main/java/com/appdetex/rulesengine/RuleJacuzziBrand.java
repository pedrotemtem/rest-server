package com.appdetex.rulesengine;

import com.appdetex.entity.MarketplaceDetection;

public class RuleJacuzziBrand extends RulesAbstract implements RulesInterface{

    //checks if the description has "jacuzzi brand" and moves the state to benign if true
    public RuleJacuzziBrand() {
    }

    @Override
    public MarketplaceDetection rulesChecker(MarketplaceDetection marketplaceDetection) {
        if (marketplaceDetection.getAccountId() == 1) {
            if (marketplaceDetection.getDescription().contains("Jacuzzi® Brand")) {
                marketplaceDetection.setState("benign");
                marketplaceDetection.setReason_code("fair-use");
            }
        }

        return marketplaceDetection;
    }
}

