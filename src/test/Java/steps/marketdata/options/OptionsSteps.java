package steps.marketdata.options;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.When;
import entities.expirations.Date;
import entities.expirations.Expirations;
import entities.options.Option;
import entities.options.OptionsResponse;
import entities.quotes.Quote;
import entities.quotes.QuotesResponse;
import entities.strikes.Strike;
import entities.strikes.Strikes;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.*;

import java.io.IOException;
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

        Strike strike = new OptionsHelper().createOptionStrike();
        Share.setShare("strike",strike);
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("symbol", symbol);
        queryParams.put("expiration",date);

        RequestSpecification request = new RequestBuilder()
                .withBasePath("markets/options/strikes")
                .withQueryParams(queryParams).build();

        Response response = ResponseBuilder.getResponse(request,"get");
        MapperHelper.setMapper(response,"strikesResponse", Strikes.class);

        Double[] reponseStrikes = ((Strikes)Share.getShare("strikesResponse")).getStrikes().getStrike();
        System.out.println("The data is:"+ reponseStrikes[0]);

    }

    @When("I call the options expiration with symbol: ([^\"]*)")
    public void ICallTheOptionsExpirationWithSymbol (String symbol){

        Date expiration = new OptionsHelper().createOptionExpiration();
        Share.setShare("expiration",expiration);
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("symbol", symbol);
        RequestSpecification request = new RequestBuilder()
                .withBasePath("markets/options/expirations")
                .withQueryParams(queryParams).build();

        Response response = ResponseBuilder.getResponse(request,"get");
        MapperHelper.setMapper(response,"expirationsResponse", Expirations.class);

    }

}
