package steps.marketdata.calendar;

import cucumber.api.java.en.Then;
import entities.calendar.Calendar;
import entities.calendar.CalendarResponse;
import utils.Share;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertCalendarSteps {
    @Then("I receive information about the month status")
    public void iReceiveInformationAboutTheMonthStatus() {
        Calendar calendar = Share.getShare("calendar");
        Calendar calendarResponse = ((CalendarResponse)Share.getShare("calendarResponse")).getCalendar();
        assertThat(calendarResponse.getMonth(), equalTo(calendar.getMonth()));
        assertThat(calendarResponse.getYear(), equalTo(calendar.getYear()));
    }
}
