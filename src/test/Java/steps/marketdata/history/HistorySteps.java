package steps.marketdata.history;

import cucumber.api.java.en.Given;
import helpers.HistoryDatesHelper;
import helpers.MapperHelper;
import cucumber.api.java.en.When;
import entities.historicalDates.Day;
import entities.historicalDates.HistoryResponse;
import helpers.PropertiesHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import steps.marketdata.BaseSteps;
import utils.*;

public class HistorySteps extends BaseSteps {

    private PropertiesHelper propertiesHelper = new PropertiesHelper();
    private String marketHistoryPath = marketPath + propertiesHelper.getProperty("MARKET_HISTORY_PATH");

    @Given("In the market there is a ([^\"]*) with a transaction on the date ([^\"]*)")
    public void inTheMarketThereIsASymbolWithATransactionOnTheDateHistoricalDate(String symbol, String historicalDate) {
        Day day = new HistoryDatesHelper().createOptionExpiration(historicalDate);
        Share.setShare("historicalDay",day);
    }

    @When("I call the historical with ([^\"]*)")
    public void ICallTheHistoricalWithSymbol(String symbol){
        RequestSpecification request = new RequestBuilder()
                .withBasePath(marketHistoryPath)
                .withQueryParams("symbol", symbol).build();
        Response response = ResponseFactory.createResponse(request, "get");
        MapperHelper.setMapper(response,"historyResponse", HistoryResponse.class);
    }
}
