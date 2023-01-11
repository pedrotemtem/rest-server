package com.appdetex.rulesengine;

import com.appdetex.entity.Account;
import com.appdetex.entity.Detection;

import javax.persistence.Entity;


public interface Rules {


    Detection checkRules(Detection detection);

}
