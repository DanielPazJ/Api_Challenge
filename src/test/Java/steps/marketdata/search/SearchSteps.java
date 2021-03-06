package steps.marketdata.search;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entities.securities.SecuritiesResponse;
import entities.securities.Security;
import helpers.MapperHelper;
import helpers.PropertiesHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import steps.marketdata.BaseSteps;
import utils.RequestBuilder;
import utils.ResponseFactory;
import utils.Share;

public class SearchSteps extends BaseSteps {

    private PropertiesHelper propertiesHelper = new PropertiesHelper();
    private String marketSearch = propertiesHelper.getProperty("MARKET_SEARCH_PATH");
    private String marketLookup = propertiesHelper.getProperty("MARKET_LOOKUP_PATH");

    @Given("There exist content related to ([^\"]*)")
    public void thereExistContentRelatedToKeyword(String keyword) {
        Security security = new Security();
        security.setDescription(keyword);
        Share.setShare("security",security);
    }

    @When("I call a query for q: ([^\"]*)")
    public void ICallAQueryForQ (String q){
        RequestSpecification request = new RequestBuilder()
                .withBasePath(marketPath + marketSearch)
                .withQueryParams("q", q).build();
        Response response = ResponseFactory.createResponse(request, "get");
        MapperHelper.setMapper(response,"securityResponse", SecuritiesResponse.class);
    }

    @Given("There are symbols related with ([^\"]*)")
    public void thereAreSymbolsRelatedWithKeyword(String keyword) {
        Security security = new Security();
        security.setSymbol(keyword);
        Share.setShare("security",security);
    }

    @When("I call the symbol for q: ([^\"]*)")
    public void ICallTheSymbolForQ (String q){
        RequestSpecification request = new RequestBuilder()
                .withBasePath(marketPath + marketLookup)
                .withQueryParams("q", q).build();
        Response response = ResponseFactory.createResponse(request, "get");
        MapperHelper.setMapper(response,"securityResponse", SecuritiesResponse.class);
    }

}
