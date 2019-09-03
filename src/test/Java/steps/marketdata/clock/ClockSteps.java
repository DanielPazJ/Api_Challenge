package steps.marketdata.clock;

import cucumber.api.java.en.Then;
import entities.clock.Clock;
import entities.clock.ClockResponse;
import helpers.MapperHelper;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.*;

public class ClockSteps {
    @When("I call the clock")
    public void ICallTheClock (){
        Clock clock = new Clock();
        clock.setState("open");
        Share.setShare("clockState",clock);
        RequestSpecification request = new RequestBuilder()
                .withBasePath("markets/clock").build();
        Response response = ResponseBuilder.getResponse(request,"get");
        MapperHelper.setMapper(response,"clockResponse", ClockResponse.class);
    }

}
