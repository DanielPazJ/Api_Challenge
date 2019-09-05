package steps.watchlist;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import entities.watchlist.Watchlist;
import entities.watchlist.Watchlists;
import helpers.MapperHelper;
import helpers.PropertiesHelper;
import helpers.WatchlistHelper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.RequestBuilder;
import utils.ResponseFactory;
import utils.Share;

public class WatchlistSteps {

    private PropertiesHelper propertiesHelper = new PropertiesHelper();
    private String watchlistPath = propertiesHelper.getProperty("WATCHLIST_PATH");
    private String watchlistSymbolsPath = propertiesHelper.getProperty("WATCHLIST_SYMBOLS_PATH");

    @Given("I have a watchlist with name: ([^\"]*)")
    public void iHaveAWatchlistWithName(String watchlistName) {
        Watchlist watchlist = new Watchlist();
        watchlist.setName(watchlistName);
        Share.setShare("watchlist",watchlist);
    }

    @When("I call the API with watchlist")
    public void iCallTheAPIWithWatchlist() {
        RequestSpecification request = new RequestBuilder()
                .withBasePath(watchlistPath)
                .build();
        Response response = ResponseFactory.createResponse(request, "get");
        MapperHelper.setMapper(response,"watchlistResponse", Watchlists.class);
    }

    @Given("I have a watchlist with id: ([^\"]*)")
    public void iHaveAWatchlistWithId(String watchlistId) {
        Watchlist watchlist = new Watchlist();
        watchlist.setId(watchlistId);
        Share.setShare("watchlist",watchlist);

    }

    @When("I call the watchlist id: ([^\"]*)")
    public void iCallTheWatchlistId(String watchlistId) {
        RequestSpecification request = new RequestBuilder()
                .withBasePath(watchlistPath + "/" + watchlistId)
                .withQueryParams("watchlist_id",watchlistId)
                .build();
        Response response = ResponseFactory.createResponse(request, "get");
        MapperHelper.setMapper(response,"watchlistResponse", Watchlists.class);
    }

    @Given("I want to create a new watchlist with name: ([^\"]*) that has symbol: ([^\"]*)")
    public void iWantToCreateANewWatchlistWithNameThatHasSymbols(String watchlistName, String symbol) {
        WatchlistHelper watchlistHelper = new WatchlistHelper();
        Watchlist watchlist = watchlistHelper.getWatchlistWithSymbol(watchlistName,symbol);
        Share.setShare("watchlist",watchlist);

    }

    @When("I call the API with watchlist name: ([^\"]*) symbol: ([^\"]*)")
    public void iCallTheAPIWithWatchlistNameSymbols(String watchlistName, String symbol) {
        RequestSpecification request = new RequestBuilder()
                .withBasePath(watchlistPath)
                .withContentType(ContentType.URLENC)
                .withQueryParams("name",watchlistName)
                .withQueryParams("symbols",symbol)
                .build();
        Response response = ResponseFactory.createResponse(request, "post");
        MapperHelper.setMapper(response,"watchlistResponse", Watchlists.class);
    }

    @Given("I want to change name of a watchlist to ([^\"]*)")
    public void iWantToChangeNameOfAWatchlistToUpdatedWatchlist(String watchlistName) {
        Watchlist watchlist = new Watchlist();
        watchlist.setName(watchlistName);
        Share.setShare("watchlist",watchlist);
    }

    @When("I call the API with the watchlist id: ([^\"]*) and the updated name ([^\"]*)")
    public void iCallTheAPIWithTheWatchlistIdAndTheUpdatedName(String watchlistId, String watchlistName) {
        RequestSpecification request = new RequestBuilder()
                .withBasePath(watchlistPath + "/" + watchlistId)
                .withContentType(ContentType.URLENC)
                .withQueryParams("watchlist_id",watchlistId)
                .withQueryParams("name",watchlistName)
                .build();
        Response response = ResponseFactory.createResponse(request, "put");
        MapperHelper.setMapper(response,"watchlistResponse", Watchlists.class);
    }

    @Given("I want to delete the watchlist with the id: ([^\"]*)")
    public void iWantToDeleteTheWatchlistWithTheId(String watchlistId) {
        Watchlist watchlist = new Watchlist();
        watchlist.setId(watchlistId);
        Share.setShare("watchlist",watchlist);
    }

    @When("I call the API with watchlist id: ([^\"]*)")
    public void iCallTheAPIWithWatchlistId(String watchlistId) {
        RequestSpecification request = new RequestBuilder()
                .withBasePath(watchlistPath + "/" + watchlistId)
                .withQueryParams("watchlist_id",watchlistId)
                .build();
        Response response = ResponseFactory.createResponse(request, "delete");
        MapperHelper.setMapper(response,"watchlistResponse", Watchlists.class);
    }

    @Given("I want to add the symbol ([^\"]*) to a watchlist with name: ([^\"]*)")
    public void iWantToAddTheSymbolToAWatchlistWithName(String symbol, String watchlistName) {
        WatchlistHelper watchlistHelper = new WatchlistHelper();
        Watchlist watchlist = watchlistHelper.getWatchlistWithSymbol(watchlistName,symbol);
        Share.setShare("watchlist",watchlist);
    }

    @When("I call the API by watchlist id: ([^\"]*) and symbol: ([^\"]*)")
    public void iCallTheAPIByWatchlistIdAndSymbol(String watchlistId, String symbol) {
        RequestSpecification request = new RequestBuilder()
                .withBasePath(watchlistPath + "/" + watchlistId + watchlistSymbolsPath)
                .withContentType(ContentType.URLENC)
                .withQueryParams("watchlist_id",watchlistId)
                .withQueryParams("symbols",symbol)
                .build();
        Response response = ResponseFactory.createResponse(request, "post");
        MapperHelper.setMapper(response,"watchlistResponse", Watchlists.class);
    }


    @Given("I want to remove the ([^\"]*) symbol from the watchlist with name: ([^\"]*)")
    public void iWantToRemoveTheSymbolFromTheWatchlistWithName(String symbol, String watchlistName) {
        WatchlistHelper watchlistHelper = new WatchlistHelper();
        Watchlist watchlist = watchlistHelper.getWatchlistWithSymbol(watchlistName,symbol);
        Share.setShare("watchlist",watchlist);
    }

    @When("I call the API to delete the watchlist by watchlist id: ([^\"]*) and symbol: ([^\"]*)")
    public void iCallTheAPIToDeleteTheWatchlistByWatchlistIdAndSymbol(String watchlistId, String symbol) {
        RequestSpecification request = new RequestBuilder()
                .withBasePath(watchlistPath + "/" + watchlistId + watchlistSymbolsPath + "/" + symbol)
                .withQueryParams("watchlist_id",watchlistId)
                .withQueryParams("symbols",symbol)
                .build();
        Response response = ResponseFactory.createResponse(request, "post");
        MapperHelper.setMapper(response,"watchlistResponse", Watchlists.class);
    }

}
