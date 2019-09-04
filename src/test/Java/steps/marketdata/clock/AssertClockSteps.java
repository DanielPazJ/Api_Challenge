package steps.marketdata.clock;

import cucumber.api.java.en.Then;
import entities.clock.ClockResponse;
import helpers.DatesHelper;
import utils.Share;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertClockSteps {

    @Then("I receive information about the current day status")
    public void iReceiveInformationAboutTheCurrentDayStatus() {
        DatesHelper datesHelper = new DatesHelper();
        ClockResponse clockResponse = Share.getShare("clockResponse");
        assertThat(datesHelper.dateIsEqualorBefore(clockResponse.getClock().getDate()),is(true));
    }
}
