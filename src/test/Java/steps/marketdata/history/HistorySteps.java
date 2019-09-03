package steps.marketdata.history;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entities.historicalDates.Day;
import entities.historicalDates.HistoryResponse;
import entities.options.Option;
import entities.options.OptionsResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.*;

import java.util.HashMap;


public class HistorySteps {
    @When("I call the historical with symbol: ([^\"]*)")
    public void ICallTheHistoricalWithSymbol(String symbol){
        Day day = new HistoryDatesHelper().createOptionExpiration();
        Share.setShare("historicalDay",day);
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("symbol", symbol);
        RequestSpecification request = new RequestBuilder()
                .withBasePath("markets/history")
                .withQueryParams(queryParams).build();
        Response response = ResponseBuilder.getResponse(request,"get");
        MapperHelper.setMapper(response,"historyResponse", HistoryResponse.class);
    }


}
