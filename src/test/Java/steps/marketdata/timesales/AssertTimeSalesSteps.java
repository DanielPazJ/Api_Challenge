package steps.marketdata.timesales;

import cucumber.api.java.en.Then;
import entities.timeSales.Data;
import entities.timeSales.TimeSalesResponse;
import helpers.DatesHelper;
import utils.Share;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertTimeSalesSteps {
    @Then("I receive time sales information of the current day related to the symbol")
    public void iReceiveTimeSalesInformationOfTheCurrentDatRelatedToTheSymbol() {
        DatesHelper datesHelper = new DatesHelper();
        List<Data> timeSalesResponse = ((TimeSalesResponse) Share.getShare("timeSalesResponse")).getSeries().getData();
        for (Data data : timeSalesResponse) {
            assertThat(datesHelper.dateIsEqualorBefore(datesHelper.dateFormatter(data.getTime())), is(true));
        }
    }
}
