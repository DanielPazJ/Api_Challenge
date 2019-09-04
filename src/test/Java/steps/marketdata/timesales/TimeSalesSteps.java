package steps.marketdata.timesales;

import helpers.MapperHelper;
import helpers.TimesSalesHelper;
import cucumber.api.java.en.When;
import entities.timeSales.Data;
import entities.timeSales.TimeSalesResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.*;

public class TimeSalesSteps {
    @When("I call the time sales with symbol: ([^\"]*)")
    public void ICallTheTimeSalesWithSymbol(String symbol){
        Data data = new TimesSalesHelper().createTimeSalesTime();
        Share.setShare("timeSale",data);
        RequestSpecification request = new RequestBuilder()
                .withBasePath("markets/timesales")
                .withQueryParams("symbol", symbol).build();
        Response response = ResponseBuilder.getResponse(request,"get");
        MapperHelper.setMapper(response,"timeSalesResponse", TimeSalesResponse.class);
    }

}
