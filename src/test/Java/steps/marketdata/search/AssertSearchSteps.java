package steps.marketdata.search;

import cucumber.api.java.en.Then;
import entities.securities.SecuritiesResponse;
import entities.securities.Security;
import helpers.SearchHelper;
import utils.Share;
import java.util.List;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertSearchSteps {

    private SearchHelper searchHelper = new SearchHelper();

    @Then("I receive information of the searched company")
    public void iReceiveInformationOfTheSearchedCompany() {
        assertThat(searchHelper.validateInformationOf("description"),is(true));
    }

    @Then("I receive information about the searched symbol")
    public void iReceiveInformationAboutTheSearchedSymbol() {
        assertThat(searchHelper.validateInformationOf("symbol"),is(true));
    }
}
