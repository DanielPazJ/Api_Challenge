package steps.marketdata.history;

import helpers.HistoryDatesHelper;
import helpers.MapperHelper;
import cucumber.api.java.en.When;
import entities.historicalDates.Day;
import entities.historicalDates.HistoryResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.*;

public class HistorySteps {
    @When("I call the historical with symbol: ([^\"]*)")
    public void ICallTheHistoricalWithSymbol(String symbol){
        Day day = new HistoryDatesHelper().createOptionExpiration();
        Share.setShare("historicalDay",day);
        RequestSpecification request = new RequestBuilder()
                .withBasePath("markets/history")
                .withQueryParams("symbol", symbol).build();
        Response response = ResponseBuilder.getResponse(request,"get");
        MapperHelper.setMapper(response,"historyResponse", HistoryResponse.class);
    }


}
