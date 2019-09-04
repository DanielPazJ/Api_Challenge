package entities.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class Day {

    @JsonProperty("day")
    private List<CalendarDay> CalendarDay;

}
