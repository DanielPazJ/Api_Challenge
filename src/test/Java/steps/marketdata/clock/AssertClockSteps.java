package steps.marketdata.clock;

import cucumber.api.java.en.Then;
import entities.clock.Clock;
import entities.clock.ClockResponse;
import utils.Share;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertClockSteps {

    @Then("I receive information about the current day status")
    public void iReceiveInformationAboutTheCurrentDayStatus() {
        Clock clock = Share.getShare("clockState");
        ClockResponse clockResponse = Share.getShare("clockResponse");
        assertThat(clock.getState(), equalTo(clockResponse.getClock().getState()));
    }
}
