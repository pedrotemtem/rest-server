package com.appdetex.rulesengine;

import com.appdetex.entity.Detection;

public class RuleSellers implements RulesInterface{

    public RuleSellers() {
    }

    @Override
    public Detection rulesChecker(Detection detection) {

        if(detection.getAccountId()==2
                && detection.getSeller().equals("Apple")){
            detection.setState("benign");
            detection.setReasonCode("fair-use");
        }
        else if (detection.getAccountId()==3
                && detection.getSeller().equals("Microsoft")){
            detection.setState("benign");
            detection.setReasonCode("fair-use");
        }

        return detection;
    }
}
