package steps.marketdata;

import cucumber.api.java.en.Given;
import utils.PropertiesHelper;
import utils.Share;

public class GeneralMarketDataSteps {

    @Given("I have an authorization token")
    public void IHaveAnAuthorizationToken (){
        Share.setShare("token",PropertiesHelper.getToken());
    }
}
