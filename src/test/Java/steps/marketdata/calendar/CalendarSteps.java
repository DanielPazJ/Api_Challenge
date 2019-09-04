package steps.marketdata.calendar;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import entities.calendar.Calendar;
import entities.calendar.CalendarResponse;
import helpers.CalendarHelper;
import helpers.MapperHelper;
import helpers.PropertiesHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import steps.marketdata.BaseSteps;
import utils.RequestBuilder;
import utils.ResponseFactory;
import utils.Share;

public class CalendarSteps extends BaseSteps {

    private PropertiesHelper propertiesHelper = new PropertiesHelper();
    private String marketCalendarPath = marketPath + propertiesHelper.getProperty("MARKET_CALENDAR_PATH");

    @Given("I want the calendar of ([^\"]*) of ([^\"]*)")
    public void iWantTheCalendarOfMonthOfYear(String month, String year) {
        Calendar calendar = new CalendarHelper().createCalendar(month,year);
        Share.setShare("calendar",calendar);
    }

    @When("I call the calendar with the ([^\"]*) of the ([^\"]*)")
    public void iCallTheCalendarWithTheMonthOfTheYear(String month, String year) {
        RequestSpecification request = new RequestBuilder()
                .withBasePath(marketCalendarPath)
                .withQueryParams("month", month)
                .withQueryParams("year", year).build();
        Response response = ResponseFactory.createResponse(request, "get");
        MapperHelper.setMapper(response,"calendarResponse", CalendarResponse.class);

    }

}
