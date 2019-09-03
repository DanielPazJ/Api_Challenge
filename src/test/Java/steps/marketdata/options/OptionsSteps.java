package steps.marketdata.options;

import cucumber.api.java.en.Given;
import helpers.MapperHelper;
import helpers.OptionsHelper;
import cucumber.api.java.en.When;
import entities.expirations.Date;
import entities.expirations.Expirations;
import entities.options.Option;
import entities.options.OptionsResponse;
import entities.strikes.Strike;
import entities.strikes.Strikes;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.*;

import java.util.HashMap;

public class OptionsSteps {

    @Given("I have an option chain of ([^\"]*) with expiration date: ([^\"]*)")
    public void iHaveAnOptionChainOfSymbolWithExpirationDateDate(String symbol, String date) {
        Option option = new OptionsHelper().createOptionExpirationDate(symbol,date);
        Share.setShare("options",option);
    }

    @When("I call quotes with symbol: ([^\"]*) expiration date: ([^\"]*)")
    public void ICallQuotesWithSymbolAndExpirationDate(String symbol, String date){
        RequestSpecification request = new RequestBuilder()
                .withBasePath("markets/options/chains")
                .withQueryParams("symbol", symbol)
                .withQueryParams("expiration",date).build();
        Response response = ResponseBuilder.getResponse(request,"get");
        MapperHelper.setMapper(response,"optionsResponse", OptionsResponse.class);

    }

    @Given("I have an option strikes of ([^\"]*) with expiration date: ([^\"]*)")
    public void iHaveAnOptionStrikesOfSymbolWithExpirationDateDate(String symbol, String date) {
        Strike strike = new OptionsHelper().createOptionStrike();
        Share.setShare("strike",strike);
    }

    @When("I call the options strikes with the symbol: ([^\"]*) expiration date: ([^\"]*)")
    public void ICallTheOptionsStrikesWithTheSymbolAndExpirationDate(String symbol, String date){
        RequestSpecification request = new RequestBuilder()
                .withBasePath("markets/options/strikes")
                .withQueryParams("symbol", symbol)
                .withQueryParams("expiration",date).build();

        Response response = ResponseBuilder.getResponse(request,"get");
        MapperHelper.setMapper(response,"strikesResponse", Strikes.class);
    }

    @Given("The ([^\"]*) exist in the market with ([^\"]*)")
    public void theSymbolExistInTheMarketWith(String symbol, String expirationDate) {
        Date expiration = new OptionsHelper().createOptionExpiration(expirationDate);
        Share.setShare("expiration",expiration);
    }

    @When("I call the options expiration with ([^\"]*)")
    public void ICallTheOptionsExpirationWithSymbol (String symbol){
        RequestSpecification request = new RequestBuilder()
                .withBasePath("markets/options/expirations")
                .withQueryParams("symbol", symbol).build();

        Response response = ResponseBuilder.getResponse(request,"get");
        MapperHelper.setMapper(response,"expirationsResponse", Expirations.class);

    }
}
