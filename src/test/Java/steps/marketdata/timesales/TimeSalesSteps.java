package steps.marketdata.timesales;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entities.quotes.Quote;
import entities.quotes.QuotesResponse;
import entities.timeSales.Data;
import entities.timeSales.TimeSalesResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.*;

import java.util.HashMap;
import java.util.List;

public class TimeSalesSteps {
    @When("I call the time sales with symbol: ([^\"]*)")
    public void ICallTheTimeSalesWithSymbol(String symbol){
        Data data = new  TimesSalesHelper().createTimeSalesTime();
        Share.setShare("timeSale",data);
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("symbol", symbol);
        RequestSpecification request = new RequestBuilder()
                .withBasePath("markets/timesales")
                .withQueryParams(queryParams).build();
        Response response = ResponseBuilder.getResponse(request,"get");
        MapperHelper.setMapper(response,"timeSalesResponse", TimeSalesResponse.class);
    }

}
