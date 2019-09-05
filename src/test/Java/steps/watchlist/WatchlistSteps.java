package steps.watchlist;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import entities.watchlist.Watchlist;
import entities.watchlist.WatchlistResponse;
import entities.watchlist.Watchlists;
import helpers.MapperHelper;
import helpers.WatchlistHelper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.RequestBuilder;
import utils.ResponseFactory;
import utils.Share;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WatchlistSteps {

    @Given("The user has a watchlist with name: ([^\"]*)")
    public void theUserHasAWatchlistWithName(String watchlistName) {
        Watchlist watchlist = new Watchlist();
        watchlist.setName(watchlistName);
        Share.setShare("watchlist",watchlist);
    }

    @When("I call the API with watchlist")
    public void iCallTheAPIWithWatchlist() {
        RequestSpecification request = new RequestBuilder()
                .withBasePath("/watchlists")
                .build();
        Response response = ResponseFactory.createResponse(request, "get");
        MapperHelper.setMapper(response,"watchlistResponse", Watchlists.class);
    }

    @Then("I receive a list of watchlist that has the user watchlist names")
    public void iReceiveAListOfWatchlistThatHasTheUserWatchlistNames() {
        Watchlist watchlist = Share.getShare("watchlist");
        List<Watchlist> watchlistResponse = ((WatchlistResponse)Share.getShare("watchlistResponse"))
                .getWatchlists().getWatchlistList();
        for (Watchlist value : watchlistResponse) {
            assertThat(watchlist.getName(), equalTo(value.getName()));
        }
    }

    @Given("The user has a watchlist with id: ([^\"]*)")
    public void theUserHasAWatchlistWithId(String watchlistId) {
        Watchlist watchlist = new Watchlist();
        watchlist.setId(watchlistId);
        Share.setShare("watchlist",watchlist);

    }

    @When("I call the watchlist id: ([^\"]*)")
    public void iCallTheWatchlistId(String watchlistId) {
        RequestSpecification request = new RequestBuilder()
                .withBasePath("/watchlists{"+watchlistId+"}")
                .build();
        Response response = ResponseFactory.createResponse(request, "get");
        MapperHelper.setMapper(response,"watchlistResponse", Watchlists.class);
    }

    @Then("I receive the watchlist by id with the correct name")
    public void iReceiveTheWatchlistByIdWithTheCorrectName() {
        Watchlist watchlist = Share.getShare("watchlist");
        Watchlist watchlistResponse = Share.getShare("watchlistResponse");
        assertThat(watchlist.getId(), equalTo(watchlistResponse.getId()));

    }

    @Given("I want to create a new watchlist with name: ([^\"]*) that has symbol: ([^\"]*)")
    public void iWantToCreateANewWatchlistWithNameThatHasSymbols(String watchlistName, String symbol) {
        WatchlistHelper watchlistHelper = new WatchlistHelper();
        Watchlist watchlist = watchlistHelper.getWatchlistWithSymbol(watchlistName,symbol);
        Share.setShare("watchlist",watchlist);

    }

    @When("I call the API  with watchlist name: ([^\"]*) symbol: ([^\"]*)")
    public void iCallTheAPIWithWatchlistNameSymbols(String watchlistName, String symbol) {
        RequestSpecification request = new RequestBuilder()
                .withBasePath("/watchlists")
                .withContentType(ContentType.URLENC)
                .withQueryParams("name",watchlistName)
                .withQueryParams("symbols",symbol)
                .build();
        Response response = ResponseFactory.createResponse(request, "post");
        MapperHelper.setMapper(response,"watchlistResponse", Watchlists.class);
    }

    @Then("I receive the new watchlist with symbols added")
    public void iReceiveTheNewWatchlistWithSymbolsAdded() {
        Watchlist watchlist = Share.getShare("watchlist");
        Watchlist watchlistResponse = Share.getShare("watchlistResponse");

        assertThat(watchlist.getName(), equalTo(watchlistResponse.getName()));

        for (int i =0; i<watchlist.getItemContent().getItems().size();i++) {
            assertThat(watchlist.getItemContent().getItems().get(i),
                    equalTo(watchlistResponse.getItemContent().getItems().get(i)));
        }
    }

    @Given("I want to change name of a watchlist to ([^\"]*)")
    public void iWantToChangeNameOfAWatchlistToUpdatedWatchlist(String watchlistName) {
        Watchlist watchlist = new Watchlist();
        watchlist.setName(watchlistName);
        Share.setShare("watchlist",watchlist);
    }

    @When("I send a request with the watchlist id: ([^\"]*) and the updated name ([^\"]*)")
    public void iSendARequestWithTheWatchlistIdAndTheUpdatedName(String watchlistId, String watchlistName) {
        RequestSpecification request = new RequestBuilder()
                .withBasePath("/watchlists{"+watchlistId+"}")
                .withContentType(ContentType.URLENC)
                .withQueryParams("watchlist_name",watchlistId)
                .withQueryParams("name",watchlistName)
                .build();
        Response response = ResponseFactory.createResponse(request, "put");
        MapperHelper.setMapper(response,"watchlistResponse", Watchlists.class);
    }

    @Then("I get the watchlist with the updated information")
    public void iGetTheWatchlistWithTheUpdatedInformation() {
        Watchlist watchlist = Share.getShare("watchlist");
        Watchlist watchlistResponse = Share.getShare("watchlistResponse");
        assertThat(watchlist.getName(), equalTo(watchlistResponse.getName()));
    }
}
