package steps.marketdata.quotes;

import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import utils.Utils;
import utils.RequestBuilder;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class QuotesSteps {

    @When("I call the quotes with symbols: ([^\"]*)")
    public void ICallTheQuotesWithSymbols(String symbols){

        RequestBuilder requestBuilder = new RequestBuilder("markets/quotes");
        RequestSpecification requestSpecification =requestBuilder.getRequestSpecification();
        Response response = given().header("Authorization", "Bearer "+ Utils.readToken())
                .queryParam("symbols", symbols)
                .spec(requestSpecification)
                .get()
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .extract()
                .response();
    }

//    @When("I post quotes with symbols: ([^\"]*)")
//    public void IPostQuotesWithSymbols (String symbols){
//
//    }


}
