package steps.marketdata.search;

import cucumber.api.java.en.Then;
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
    @When("I call a query for q: ([^\"]*)")
    public void ICallAQueryForQ (String q){
        Security security = new Security();
        security.setDescription(q);
        Share.setShare("security",security);
        RequestSpecification request = new RequestBuilder()
                .withBasePath("markets/search")
                .withQueryParams("q", q).build();
        Response response = ResponseBuilder.getResponse(request,"get");
        MapperHelper.setMapper(response,"securityResponse", SecuritiesResponse.class);
    }

    @When("I call the symbol for q: ([^\"]*)")
    public void ICallTheSymbolForQ (String q){
        Security security = new Security();
        security.setSymbol(q);
        Share.setShare("symbol",security);
        RequestSpecification request = new RequestBuilder()
                .withBasePath("markets/lookup")
                .withQueryParams("q", q).build();
        Response response = ResponseBuilder.getResponse(request,"get");
        MapperHelper.setMapper(response,"symbolResponse", SecuritiesResponse.class);
    }

}
