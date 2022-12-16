package com.appdetex.rulesengine;

import com.appdetex.entity.MarketplaceDetection;

public class RuleAppleSeller extends RulesAbstract implements RulesInterface{

    //checks if seller is apple for apple products
    public RuleAppleSeller() {
    }

    @Override
    public MarketplaceDetection rulesChecker(MarketplaceDetection marketplaceDetection) {

        if(marketplaceDetection.getAccountId()==2
                && marketplaceDetection.getSeller().equals("Apple")){
            marketplaceDetection.setState("benign");
        }

        return marketplaceDetection;
    }
}
