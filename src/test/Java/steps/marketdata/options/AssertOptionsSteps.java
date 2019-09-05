package steps.marketdata.options;

import cucumber.api.java.en.Then;
import helpers.OptionsHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertOptionsSteps {
    private OptionsHelper optionsHelper = new OptionsHelper();

    @Then("I receive quotes related to the symbol with the expiration date only")
    public void iReceiveQuotesRelatedToTheSymbolWithTheExpirationDateOnly() {
        assertThat(optionsHelper.verifyQuotesContainsExpirationDateOnly("options",
                "optionsResponse"),is(true));

    }

    @Then("I receive the strikes related to the symbol with the expiration date only")
    public void iReceiveTheStrikesRelatedToTheSymbolWithTheExpirationDateOnly() {
        assertThat(optionsHelper.verifyStrikesContainsExpirationDateOnly("strike",
                "strikesResponse"),is(true));
}

    @Then("I receive expiration dates including ([^\"]*)")
    public void iReceiveExpirationDatesIncluding(String expirationDate) {
        assertThat(optionsHelper.verifyContainsExpirationDate(expirationDate,
                "expirationsResponse"),is(true));
    }
}
