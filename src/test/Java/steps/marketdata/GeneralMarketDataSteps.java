package steps.marketdata;

import cucumber.api.java.en.Given;
import utils.PropertiesHelper;

public class GeneralMarketDataSteps {

    @Given("I have an authorization token")
    public void IHaveAnAuthorizationToken (){
        PropertiesHelper.Token();
    }
}
