package steps.marketdata.history;

import cucumber.api.java.en.Then;
import entities.historicalDates.Day;
import entities.historicalDates.HistoryResponse;
import helpers.HistoryDatesHelper;
import utils.Share;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertHistorySteps {

    @Then("I receive the historical pricing related to the symbol")
    public void iReceiveTheHistoricalPricingRelatedToTheSymbol() {
        HistoryDatesHelper historyDatesHelper = new HistoryDatesHelper();
        assertThat(historyDatesHelper
                .verifyHistoricalContainsDay("historicalDay","historyResponse")
                ,equalTo(true));
    }
}





