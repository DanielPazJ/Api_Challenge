package steps.marketdata.common;

import cucumber.api.java.en.Given;
import helpers.PropertiesHelper;
import steps.marketdata.BaseSteps;
import utils.Share;

public class GeneralMarketDataSteps extends BaseSteps {

    private PropertiesHelper propertiesHelper = new PropertiesHelper();

    @Given("I have an authorization token")
    public void IHaveAnAuthorizationToken (){
        Share.setShare("token",propertiesHelper.getToken());
    }
}
