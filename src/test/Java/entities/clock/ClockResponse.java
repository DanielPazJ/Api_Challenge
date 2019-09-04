package entities.clock;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClockResponse {


    @JsonProperty("clock")
    private Clock clock;

    public Clock getClock() {
        return clock;
    }
}

