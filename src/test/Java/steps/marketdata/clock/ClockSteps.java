package steps.marketdata.clock;

import entities.clock.ClockResponse;
import helpers.MapperHelper;
import cucumber.api.java.en.When;
import helpers.PropertiesHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import steps.marketdata.BaseSteps;
import utils.*;

public class ClockSteps extends BaseSteps {
    private PropertiesHelper propertiesHelper = new PropertiesHelper();
    private String marketClockPath = marketPath + propertiesHelper.getProperty("MARKET_CLOCK_PATH");

    @When("I call the clock")
    public void ICallTheClock (){
        RequestSpecification request = new RequestBuilder()
                .withBasePath(marketClockPath).build();
        Response response = ResponseFactory.createResponse(request, "get");
        MapperHelper.setMapper(response,"clockResponse", ClockResponse.class);
    }

}
