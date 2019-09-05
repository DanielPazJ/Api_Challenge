package steps.watchlist;

import cucumber.api.java.en.Then;
import entities.watchlist.Watchlist;
import entities.watchlist.WatchlistResponse;
import helpers.WatchlistHelper;
import utils.Share;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertWatchlistSteps {

    private WatchlistHelper watchlistHelper = new WatchlistHelper();

    @Then("I receive a list of watchlist that has the user watchlist names")
    public void iReceiveAListOfWatchlistThatHasTheUserWatchlistNames() {
        assertThat(watchlistHelper.validateWatchlistHasName("watchlist",
                "watchlistResponse"),is(true));
    }

    @Then("I receive the watchlist by id with the correct name")
    public void iReceiveTheWatchlistByIdWithTheCorrectName() {
        assertThat(watchlistHelper.validateInformationOf("id"),is(true));
    }

    @Then("I receive the new watchlist with symbols added")
    public void iReceiveTheNewWatchlistWithSymbolsAdded() {
        assertThat(watchlistHelper.verifyWatchlistContainsSymbol("watchlist",
                "watchlistResponse"), is(true));
    }

    @Then("I receive the watchlist with the updated information")
    public void iReceiveTheWatchlistWithTheUpdatedInformation() {
        assertThat(watchlistHelper.validateInformationOf("name"),is(true));
    }

    @Then("I receive the deleted watchlist")
    public void iReceiveTheDeletedWatchlist() {
       assertThat(watchlistHelper.validateInformationOf("id"),is(true));
    }

    @Then("I receive the watchlist with the added symbol")
    public void iReceiveTheWatchlistWithTheAddedSymbol() {
        assertThat(watchlistHelper.verifyWatchlistContainsSymbol("watchlist",
                "watchlistResponse"), is(true));
    }

    @Then("I receive the watchlist without the deleted symbol")
    public void iReceiveTheWatchlistWithoutTheDeletedSymbol() {
        assertThat(watchlistHelper.verifyWatchlistContainsSymbol("watchlist",
                "watchlistResponse"), is(false));
    }
}
