package com.appdetex.rulesengine;

import com.appdetex.entity.Account;
import com.appdetex.entity.MarketplaceDetection;

public interface RulesInterface {

    MarketplaceDetection rulesChecker(MarketplaceDetection marketplaceDetection);

}
