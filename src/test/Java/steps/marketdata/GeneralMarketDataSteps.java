package steps.marketdata;

import cucumber.api.java.en.Given;
import utils.PropertiesHelper;
import utils.Utils;

public class GeneralMarketDataSteps {

    @Given("I have an authorization token")
    public void IHaveAnAuthorizationToken (){
        Utils.readToken();
        //PropertiesHelper.testtoken();
    }
}
