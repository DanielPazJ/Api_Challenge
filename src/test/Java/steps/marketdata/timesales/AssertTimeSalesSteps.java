package steps.marketdata.timesales;

import cucumber.api.java.en.Then;
import entities.timeSales.Data;
import entities.timeSales.TimeSalesResponse;
import utils.Share;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertTimeSalesSteps {
    @Then("I receive time sales information related to the symbol")
    public void iReceiveTimeSalesInformationRelatedToTheSymbol() {
        Data timeSales = Share.getShare("timeSale");
        List<Data> timeSalesResponse = ((TimeSalesResponse) Share.getShare("timeSalesResponse")).getSeries().getData();
        assertThat(timeSales.getTime(), equalTo(timeSalesResponse.get(0).getTime()));
    }
}
