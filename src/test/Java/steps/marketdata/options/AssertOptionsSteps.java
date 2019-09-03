package steps.marketdata.options;

import cucumber.api.java.en.Then;
import entities.expirations.Date;
import entities.expirations.Expirations;
import entities.options.Option;
import entities.options.OptionsResponse;
import entities.strikes.Strike;
import entities.strikes.Strikes;
import utils.Share;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertOptionsSteps {
    @Then("I receive quotes related to the symbol with the expiration date only")
    public void iReceiveQuotesRelatedToTheSymbolWithTheExpirationDateOnly() {
        Option options = Share.getShare("options");
        List<Option> optionResponse = ((OptionsResponse)Share.getShare("optionsResponse")).getOptions().getOption();

        assertThat(options.getRootSymbol(), equalTo(optionResponse.get(0).getRootSymbol()));
        assertThat(options.getExpirationDate(), equalTo(optionResponse.get(0).getExpirationDate()));

    }

    @Then("I receive the strikes related to the symbol with the expiration date only")
    public void iReceiveTheStrikesRelatedToTheSymbolWithTheExpirationDateOnly() {
        Strike strike = Share.getShare("strike");
        Double[] strikeResponse = ((Strikes)Share.getShare("strikesResponse")).getStrikes().getStrike();

        assertThat(strike.getStrike()[0], equalTo(strikeResponse[0]));
}

    @Then("I receive the expiration dates related to the symbol")
    public void iReceiveTheExpirationDatesRelatedToTheSymbol() {
        Date expirationDate = Share.getShare("expiration");
        String[] expirationDateResponse = ((Expirations)Share.getShare("expirationsResponse")).getDates().getExpirations();

        assertThat(expirationDate.getExpirations()[0], equalTo(expirationDateResponse[0]));
    }
}
