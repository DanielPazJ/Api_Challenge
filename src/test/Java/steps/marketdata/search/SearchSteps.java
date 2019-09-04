package steps.marketdata.search;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import entities.securities.SecuritiesResponse;
import entities.securities.Security;
import helpers.MapperHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.RequestBuilder;
import utils.ResponseBuilder;
import utils.Share;

public class SearchSteps {

    @Given("There exist content related to ([^\"]*)")
    public void thereExistContentRelatedToKeyword(String keyword) {
        Security security = new Security();
        security.setDescription(keyword);
        Share.setShare("security",security);
    }

    @When("I call a query for q: ([^\"]*)")
    public void ICallAQueryForQ (String q){
        RequestSpecification request = new RequestBuilder()
                .withBasePath("markets/search")
                .withQueryParams("q", q).build();
        Response response = ResponseBuilder.getResponse(request,"get");
        MapperHelper.setMapper(response,"securityResponse", SecuritiesResponse.class);
    }

    @Given("There are symbols related with ([^\"]*)")
    public void thereAreSymbolsRelatedWithKeyword(String keyword) {
        Security security = new Security();
        security.setSymbol(keyword);
        Share.setShare("symbol",security);
    }

    @When("I call the symbol for q: ([^\"]*)")
    public void ICallTheSymbolForQ (String q){
        RequestSpecification request = new RequestBuilder()
                .withBasePath("markets/lookup")
                .withQueryParams("q", q).build();
        Response response = ResponseBuilder.getResponse(request,"get");
        MapperHelper.setMapper(response,"symbolResponse", SecuritiesResponse.class);
    }

}
