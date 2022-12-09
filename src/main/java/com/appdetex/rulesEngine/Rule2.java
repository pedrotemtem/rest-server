package com.appdetex.rulesEngine;

import com.appdetex.entity.MarketplaceDetection;

public class Rule2 extends RulesAbstract implements RulesInterface{

    //checks if the description has "jacuzzi brand" and moves the state to benign if true
    public Rule2() {
    }

    @Override
    public MarketplaceDetection rulesChecker(MarketplaceDetection marketplaceDetection) {
        //if (marketplaceDetection.getAccountId() == 1) {
            if (marketplaceDetection.getDescription().contains("Jacuzzi® Brand")) {
                marketplaceDetection.setState("benign");
            }
        //}

        return marketplaceDetection;
    }
}

