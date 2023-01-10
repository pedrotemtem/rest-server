package com.appdetex.rulesengine;

import com.appdetex.entity.Account;
import com.appdetex.entity.Detection;

public interface Rules {


    Detection checkRules(Detection detection);

}
