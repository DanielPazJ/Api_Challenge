package steps.marketdata;

import cucumber.api.java.en.Given;
import helpers.PropertiesHelper;
import utils.Share;

public class GeneralMarketDataSteps {

    private PropertiesHelper propertiesHelper = new PropertiesHelper();
    @Given("I have an authorization token")
    public void IHaveAnAuthorizationToken (){
        Share.setShare("token",propertiesHelper.getToken());
    }
}
