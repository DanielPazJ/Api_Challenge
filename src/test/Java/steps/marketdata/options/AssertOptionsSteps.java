package steps.marketdata.options;

import cucumber.api.java.en.Then;
import entities.options.Option;
import entities.options.OptionsResponse;
import utils.Share;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertOptionsSteps {
    @Then("I receive quotes related to the symbol with the expiration date only")
    public void iReceiveQuotesRelatedToTheSymbolWithTheExpirationDateOnly() {
        Option options= Share.getShare("options");
        List<Option> optionResponse = ((OptionsResponse)Share.getShare("optionsResponse")).getOptions().getOption();

            assertThat(options.getRootSymbol(), equalTo(optionResponse.get(0).getRootSymbol()));
            assertThat(options.getExpirationDate(), equalTo(optionResponse.get(0).getExpirationDate()));

    }

    @Then("I receive the strikes related to the symbol with the expiration date only")
    public void iReceiveTheStrikesRelatedToTheSymbolWithTheExpirationDateOnly() {

    }
}
