package steps.marketdata.quotes;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.When;

import entities.Quotes;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.RequestBuilder;


import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class QuotesSteps {

    @When("I call the quotes with symbols: ([^\"]*)")
    public void ICallTheQuotesWithSymbols(String symbols) throws IOException {

        RequestBuilder requestBuilder = new RequestBuilder("markets","quotes");
        RequestSpecification requestSpecification = requestBuilder.getRequestSpecification();
        Response response = given().queryParam("symbols", symbols)
                .spec(requestSpecification)
                .get()
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .extract()
                .response();

       List<Quotes> result = response.path("quotes.quote");
       ObjectMapper mapper = new ObjectMapper();
       TypeReference<List<Quotes>> typeReference = new TypeReference<List<Quotes>>() {};
       String resultJson =mapper.writeValueAsString(result);
       List<Quotes> quotes = mapper.readValue(resultJson, typeReference);

    }

    @When("I post quotes with symbols: ([^\"]*)")
    public void IPostQuotesWithSymbols (String symbols){

    }


}
