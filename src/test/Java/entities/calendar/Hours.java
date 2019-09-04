package entities.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hours {

    @JsonProperty("start")
    private String start;
    @JsonProperty("end")
    private String end;
}
