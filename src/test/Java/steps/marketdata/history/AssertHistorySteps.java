package steps.marketdata.history;

import cucumber.api.java.en.Then;
import entities.historicalDates.Day;
import entities.historicalDates.HistoryResponse;
import entities.options.Option;
import entities.options.OptionsResponse;
import utils.Share;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertHistorySteps {

    @Then("I receive the historical pricing related to the symbol")
    public void iReceiveTheHistoricalPricingRelatedToTheSymbol() {
        Day historicalDate = Share.getShare("historicalDay");
        List<Day> historicalResponse = ((HistoryResponse)Share.getShare("historyResponse")).getDates().getDays();
        assertThat(historicalDate.getDate(), equalTo(historicalResponse.get(0).getDate()));
    }
}





