package steps.marketdata.options;

import cucumber.api.java.en.When;
import entities.options.Option;
import entities.options.OptionsResponse;
import entities.quotes.Quote;
import entities.quotes.QuotesResponse;
import entities.strikes.Strike;
import entities.strikes.Strikes;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.*;
import java.util.HashMap;
import java.util.List;

public class OptionsSteps {

    @When("I call quotes with symbol: ([^\"]*) expiration date: ([^\"]*)")
    public void ICallQuotesWithSymbolAndExpirationDate(String symbol, String date){

        Option option = new OptionsHelper().createOptionExpirationDate(symbol,date);
        Share.setShare("options",option);
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("symbol", symbol);
        queryParams.put("expiration",date);
        RequestSpecification request = new RequestBuilder()
                .withBasePath("markets/options/chains")
                .withQueryParams(queryParams).build();
        Response response = ResponseBuilder.getResponse(request,"get");
        MapperHelper.setMapper(response,"optionsResponse", OptionsResponse.class);

    }

    @When("I call the options strikes with the symbol: ([^\"]*) expiration date: ([^\"]*)")
    public void ICallTheOptionsStrikesWithTheSymbolAndExpirationDate(String symbol, String date){

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("symbol", symbol);
        queryParams.put("expiration",date);
        RequestSpecification request = new RequestBuilder()
                .withBasePath("markets/options/strikes")
                .withQueryParams(queryParams).build();
        Response response = ResponseBuilder.getResponse(request,"get");
        MapperHelper.setMapper(response,"strikesResponse", Strikes.class);
        Strikes strikeslist = Share.getShare("strikesResponse");
        System.out.println(strikeslist.getStrikes().toString());
    }

    @When("I call the options expiration with symbol: ([^\"]*)")
    public void ICallTheOptionsExpirationWithSymbol (String symbol){

    }

}
