package steps.marketdata.search;

import cucumber.api.java.en.Then;
import entities.securities.SecuritiesResponse;
import entities.securities.Security;
import utils.Share;
import java.util.List;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertSearchSteps {
    @Then("I receive information of the searched company")
    public void iReceiveInformationOfTheSearchedCompany() {
        Security security= Share.getShare("security");
        List<Security> securitiesResponse =((SecuritiesResponse)Share.getShare("securityResponse")).getSecurities().getSecurity();
        for (Security value : securitiesResponse)
            assertThat(value.getDescription(), containsStringIgnoringCase(security.getDescription()));
    }

    @Then("I receive information about the searched symbol")
    public void iReceiveInformationAboutTheSearchedSymbol() {
        Security security= Share.getShare("symbol");
        List<Security> securitiesResponse =((SecuritiesResponse)Share.getShare("symbolResponse")).getSecurities().getSecurity();
        for (Security value : securitiesResponse)
            assertThat(value.getSymbol(), containsStringIgnoringCase(security.getSymbol()));
    }
}
