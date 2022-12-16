package com.appdetex.rulesengine;

import com.appdetex.entity.MarketplaceDetection;

public class Rule4  extends RulesAbstract implements RulesInterface{
    public Rule4() {
    }

    @Override
    public MarketplaceDetection rulesChecker(MarketplaceDetection marketplaceDetection) {


        return marketplaceDetection;
    }
}
