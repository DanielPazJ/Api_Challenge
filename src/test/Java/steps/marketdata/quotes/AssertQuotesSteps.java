package steps.marketdata.quotes;

import cucumber.api.java.en.Then;
import entities.Quote;
import entities.QuotesResponse;
import utils.Share;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertQuotesSteps {

    @Then("I receive a list with only the called symbols")
    public void iReceiveAListWithOnlyTheCalledSymbols() {
        List<Quote> quotes= Share.getShare("quotes");
        List<Quote> quoteResponse = ((QuotesResponse)Share.getShare("quotesResponse")).getQuotes().getQuote();

        for (int i =0; i<quotes.size();i++)
            assertThat(quotes.get(i).getSymbol(), equalTo(quoteResponse.get(i).getSymbol()));
    }
       // assertThat(quotes.get().getSymbol(), equalTo(quoteResponse.getSymbol()));

}
