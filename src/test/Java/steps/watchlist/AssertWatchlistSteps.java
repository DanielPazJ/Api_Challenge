package steps.watchlist;

import cucumber.api.java.en.Then;
import entities.watchlist.Watchlist;
import entities.watchlist.WatchlistResponse;
import helpers.WatchlistHelper;
import utils.Share;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertWatchlistSteps {

    @Then("I receive a list of watchlist that has the user watchlist names")
    public void iReceiveAListOfWatchlistThatHasTheUserWatchlistNames() {
        Watchlist watchlist = Share.getShare("watchlist");
        List<Watchlist> watchlistResponse = ((WatchlistResponse)Share.getShare("watchlistResponse"))
                .getWatchlists().getWatchlistList();
        for (Watchlist value : watchlistResponse) {
            assertThat(watchlist.getName(), equalTo(value.getName()));
        }
    }

    @Then("I receive the watchlist by id with the correct name")
    public void iReceiveTheWatchlistByIdWithTheCorrectName() {
        Watchlist watchlist = Share.getShare("watchlist");
        Watchlist watchlistResponse = Share.getShare("watchlistResponse");
        assertThat(watchlist.getId(), equalTo(watchlistResponse.getId()));

    }

    @Then("I receive the new watchlist with symbols added")
    public void iReceiveTheNewWatchlistWithSymbolsAdded() {
        WatchlistHelper watchlistHelper = new WatchlistHelper();
        assertThat(watchlistHelper.verifyWatchlistContainsSymbol("watchlist",
                "watchlistResponse"), equalTo(true));
    }

    @Then("I receive the watchlist with the updated information")
    public void iReceiveTheWatchlistWithTheUpdatedInformation() {
        Watchlist watchlist = Share.getShare("watchlist");
        Watchlist watchlistResponse = Share.getShare("watchlistResponse");
        assertThat(watchlist.getName(), equalTo(watchlistResponse.getName()));
    }

    @Then("I receive the deleted watchlist")
    public void iReceiveTheDeletedWatchlist() {
        Watchlist watchlist = Share.getShare("watchlist");
        Watchlist watchlistResponse = Share.getShare("watchlistResponse");
        assertThat(watchlist.getId(), equalTo(watchlistResponse.getId()));
    }

    @Then("I receive the watchlist with the added symbol")
    public void iReceiveTheWatchlistWithTheAddedSymbol() {
        WatchlistHelper watchlistHelper = new WatchlistHelper();
        assertThat(watchlistHelper.verifyWatchlistContainsSymbol("watchlist",
                "watchlistResponse"), equalTo(true));
    }

    @Then("I receive the watchlist without the deleted symbol")
    public void iReceiveTheWatchlistWithoutTheDeletedSymbol() {
        WatchlistHelper watchlistHelper = new WatchlistHelper();
        assertThat(watchlistHelper.verifyWatchlistContainsSymbol("watchlist",
                "watchlistResponse"), equalTo(false));
    }
}
