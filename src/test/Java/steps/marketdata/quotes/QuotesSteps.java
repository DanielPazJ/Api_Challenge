package steps.marketdata.quotes;


import cucumber.api.java.en.Given;
import helpers.MapperHelper;
import helpers.PropertiesHelper;
import helpers.QuotesHelper;
import cucumber.api.java.en.When;
import entities.quotes.Quote;
import entities.quotes.QuotesResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import steps.marketdata.BaseSteps;
import utils.*;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class QuotesSteps extends BaseSteps {

    private PropertiesHelper propertiesHelper = new PropertiesHelper();
    private String marketQuotesPath = marketPath + propertiesHelper.getProperty("MARKET_QUOTES_PATH");

    @Given("In the market exist ([^\"]*)")
    public void inTheMarketExistSymbols(String symbols) {
        List <Quote> quotes = new QuotesHelper().setQuotesSymbols(symbols);
        Share.setShare("quotes",quotes);
    }

    @When("I call the quotes with ([^\"]*)")
    public void iCallTheQuotesWithSymbols(String symbols) {
        RequestSpecification request = new RequestBuilder()
                .withBasePath(marketQuotesPath)
                .withQueryParams("symbols", symbols).build();
        Response response = ResponseFactory.createResponse(request, "get");
        MapperHelper.setMapper(response,"quotesResponse", QuotesResponse.class);
    }

    @When("I post quotes with symbols: ([^\"]*)")
    public void iPostQuotesWithSymbols (String symbols){

        List <Quote> quotes= new QuotesHelper().setQuotesSymbols(symbols);
        Share.setShare("quotes",quotes);
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("symbols", symbols);
        RequestSpecification request = new RequestBuilder()
                .withBasePath(marketQuotesPath)
                .withContentType(ContentType.URLENC)
                .withContentParams(queryParams)
                .build();
        Response response = ResponseFactory.createResponse(request, "post");
        MapperHelper.setMapper(response,"quotesResponse", QuotesResponse.class);
    }



}
