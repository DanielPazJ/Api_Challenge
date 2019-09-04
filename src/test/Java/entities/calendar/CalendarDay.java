package entities.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalendarDay {

    @JsonProperty("date")
    private String date;
    @JsonProperty("status")
    private String status;
    @JsonProperty("description")
    private String description;
    @JsonProperty("premarket")
    private Hours premarket;
    @JsonProperty("open")
    private Hours open;
    @JsonProperty("postmarket")
    private Hours postMarket;
}
