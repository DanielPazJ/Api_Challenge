package steps.marketdata.quotes;


import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entities.Quote;
import entities.QuotesResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class QuotesSteps {

    @When("I call the quotes with symbols: ([^\"]*)")
    public void iCallTheQuotesWithSymbols(String symbols) throws IOException {

        String[] symbolsList = symbols.split(",");
        List<Quote> quotes = new ArrayList<>();
        for (String symbol : symbolsList){
            Quote quote = new Quote();
            quote = QuotesHelper.createQuoteSymbol(quote,symbol);
            quotes.add(quote);
        }
        Share.setShare("quotes",quotes);

        RequestBuilder requestBuilder = new RequestBuilder("markets","quotes");
        RequestSpecification requestSpecification = requestBuilder.getRequestSpecification();
        Response response = ResponseBuilder.getResponse(requestSpecification,"symbols", symbols);
        MapperHelper.setMapper(response,"quotesResponse", QuotesResponse.class);
//        Response response = given().queryParam("symbols", symbols)
//                .spec(requestSpecification)
//                .get()
//                .then()
//                .assertThat()
//                .statusCode(SC_OK)
//                .extract()
//                .response();

//        ObjectMapper mapper = new ObjectMapper();
//            HashMap<String, HashMap<String, ArrayList<Quote>>> quotef = mapper
//                   .readValue(response.getBody().asString(), HashMap.class);
//            Quote quoteprueba = quotef.get("quotes").get("quote").get(0);
//            System.out.println("The data is:"+ quoteprueba.getSymbol());

//        QuotesResponse quotes = mapper.readValue(response.getBody().asString(), QuotesResponse.class);
    }

    @When("I post quotes with symbols: ([^\"]*)")
    public void iPostQuotesWithSymbols (String symbols){

    }



}
