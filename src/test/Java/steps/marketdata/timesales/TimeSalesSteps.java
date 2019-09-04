package steps.marketdata.timesales;

import helpers.MapperHelper;
import cucumber.api.java.en.When;
import entities.timeSales.TimeSalesResponse;
import helpers.PropertiesHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import steps.marketdata.BaseSteps;
import utils.*;

public class TimeSalesSteps extends BaseSteps {

    private PropertiesHelper propertiesHelper = new PropertiesHelper();
    private String marketTimeSalesPath = marketPath + propertiesHelper.getProperty("MARKET_TIMESALES_PATH");

    @When("I call the time sales with symbol: ([^\"]*)")
    public void ICallTheTimeSalesWithSymbol(String symbol){
        RequestSpecification request = new RequestBuilder()
                .withBasePath(marketTimeSalesPath)
                .withQueryParams("symbol", symbol).build();
        Response response = ResponseFactory.createResponse(request, "get");
        MapperHelper.setMapper(response,"timeSalesResponse", TimeSalesResponse.class);
    }

}
