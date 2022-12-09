package com.appdetex.rulesEngine;

import com.appdetex.entity.MarketplaceDetection;

public class Rule1 extends RulesAbstract implements RulesInterface {

    //checks if there is the word inflatable and derivatives in the description of the marketplace detection
    public Rule1() {
    }

    @Override
    public MarketplaceDetection rulesChecker(MarketplaceDetection marketplaceDetection){
        //if(marketplaceDetection.getAccountId()== 1) {

            if (marketplaceDetection.getDescription().toLowerCase().contains("inflatable") ||
                    marketplaceDetection.getDescription().toLowerCase().contains("insuflável") ||
                    marketplaceDetection.getDescription().toLowerCase().contains("inflable")) {
                marketplaceDetection.setState("enforce");
            }
        //}
        return marketplaceDetection;
    }

}
