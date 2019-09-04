package steps.marketdata;

import helpers.PropertiesHelper;

public class BaseSteps {
    private PropertiesHelper propertiesHelper = new PropertiesHelper();
    protected String marketPath = propertiesHelper.getProperty("MARKET_PATH");
}
