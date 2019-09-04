package entities.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalendarResponse {



    @JsonProperty("calendar")
    private Calendar calendar;

    public Calendar getCalendar() {
        return calendar;
    }
}
