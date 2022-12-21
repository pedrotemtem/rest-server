package com.appdetex.rulesengine;

import com.appdetex.entity.Detection;

public class RuleJacuzziInflatable extends RulesAbstract implements RulesInterface {

    public RuleJacuzziInflatable() {
    }

    @Override
    public Detection rulesChecker(Detection detection){

        if (detection.getAccountId() == 1) {
            if (detection.getDescription().toLowerCase().contains("inflatable")
                    || detection.getDescription().toLowerCase().contains("insuflável")
                    || detection.getDescription().toLowerCase().contains("inflável")
                    || detection.getDescription().toLowerCase().contains("inflable")
                    || detection.getTitle().toLowerCase().contains("inflatable")
                    || detection.getTitle().toLowerCase().contains("insuflável")
                    || detection.getTitle().toLowerCase().contains("inflable")) {
                detection.setState("enforce");
                detection.setReasonCode("brand misuse");
            }
        }

        return detection;
    }

}
