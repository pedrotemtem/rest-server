package com.appdetex.rulesengine;

import com.appdetex.entity.MarketplaceDetection;

public class RuleSellers extends RulesAbstract implements RulesInterface{

    public RuleSellers() {
    }

    @Override
    public MarketplaceDetection rulesChecker(MarketplaceDetection marketplaceDetection) {

        if(marketplaceDetection.getAccountId()==2
                && marketplaceDetection.getSeller().equals("Apple")){
            marketplaceDetection.setState("benign");
            marketplaceDetection.setReasonCode("fair-use");
        }
        else if (marketplaceDetection.getAccountId()==3
                && marketplaceDetection.getSeller().equals("Microsoft")){
            marketplaceDetection.setState("benign");
            marketplaceDetection.setReasonCode("fair-use");
        }

        return marketplaceDetection;
    }
}
