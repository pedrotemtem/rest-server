package com.appdetex.rulesengine;

import com.appdetex.entity.MarketplaceDetection;

public class RuleJacuzziInflatable extends RulesAbstract implements RulesInterface {

    public RuleJacuzziInflatable() {
    }

    @Override
    public MarketplaceDetection rulesChecker(MarketplaceDetection marketplaceDetection){

        if (marketplaceDetection.getAccountId() == 1) {
            if (marketplaceDetection.getDescription().toLowerCase().contains("inflatable")
                    || marketplaceDetection.getDescription().toLowerCase().contains("insuflável")
                    || marketplaceDetection.getDescription().toLowerCase().contains("inflável")
                    || marketplaceDetection.getDescription().toLowerCase().contains("inflable")
                    || marketplaceDetection.getTitle().toLowerCase().contains("inflatable")
                    || marketplaceDetection.getTitle().toLowerCase().contains("insuflável")
                    || marketplaceDetection.getTitle().toLowerCase().contains("inflable")) {
                marketplaceDetection.setState("enforce");
                marketplaceDetection.setReasonCode("brand misuse");
            }
        }

        return marketplaceDetection;
    }

}
