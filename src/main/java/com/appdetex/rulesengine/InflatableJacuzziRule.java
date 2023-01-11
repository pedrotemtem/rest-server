package com.appdetex.rulesengine;

import com.appdetex.entity.Detection;

import java.util.ArrayList;
import java.util.List;

public class InflatableJacuzziRule implements Rules {

    public InflatableJacuzziRule() {
    }

    List<String> namesToEnforce = new ArrayList<>();


    @Override
    public Detection checkRules(Detection detection){

        namesToEnforce.add("hinchable");
        namesToEnforce.add("insuflável");
        namesToEnforce.add("inflável");
        namesToEnforce.add("inflable");
        namesToEnforce.add("insuflável");
        namesToEnforce.add("inflatable");


        if (detection.getAccountId() == 1) {
            for (String names : namesToEnforce) {
                if (detection.getDescription().toLowerCase().contains(names)
                        || detection.getTitle().toLowerCase().contains(names)) {
                    detection.setState("enforce");
                    detection.setReasonCode("brand misuse");
                }
            }
        }



        return detection;
    }

}
