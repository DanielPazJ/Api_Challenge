package steps.marketdata.quotes;


import cucumber.api.java.en.Given;
import gherkin.ast.DataTable;
import helpers.MapperHelper;
import helpers.QuotesHelper;
import cucumber.api.java.en.When;
import entities.quotes.Quote;
import entities.quotes.QuotesResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.*;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class QuotesSteps {

    @Given("In the market exist ([^\"]*)")
    public void inTheMarketExistSymbols(String symbols) {
        List <Quote> quotes = new QuotesHelper().setQuotesSymbols(symbols);
        Share.setShare("quotes",quotes);
    }

    @When("I call the quotes with ([^\"]*)")
    public void iCallTheQuotesWithSymbols(String symbols) {
        RequestSpecification request = new RequestBuilder()
                .withBasePath("markets/quotes")
                .withQueryParams("symbols", symbols).build();
        Response response = ResponseBuilder.getResponse(request,"get");
        MapperHelper.setMapper(response,"quotesResponse", QuotesResponse.class);
    }

    @When("I post quotes with symbols: ([^\"]*)")
    public void iPostQuotesWithSymbols (String symbols){

        List <Quote> quotes= new QuotesHelper().setQuotesSymbols(symbols);
        Share.setShare("quotes",quotes);
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("symbols", symbols);
        RequestSpecification request = new RequestBuilder()
                .withBasePath("markets/quotes")
                .withContentType(ContentType.URLENC)
                .withContentParams(queryParams)
                .build();
        Response response = ResponseBuilder.getResponse(request,"post");
        MapperHelper.setMapper(response,"quotesResponse", QuotesResponse.class);
    }



}
