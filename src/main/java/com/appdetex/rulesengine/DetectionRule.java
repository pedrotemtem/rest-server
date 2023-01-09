package com.appdetex.rulesengine;

import com.appdetex.entity.Detection;

public interface DetectionRule {

    Detection checkRule(Detection detection);

}
