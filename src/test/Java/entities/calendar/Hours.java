package entities.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;

class Hours {

    @JsonProperty("start")
    private String start;
    @JsonProperty("end")
    private String end;
}
