package entities.strikes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Strikes {
    @JsonProperty("strikes")
    private Strike strikes;

    public Strike getStrikes() {
        return strikes;
    }
}
