package entities.historicalDates;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class History {

    @JsonProperty("day")
    private List<Day> days;

    public List<Day> getDays() {
        return days;
    }
}
