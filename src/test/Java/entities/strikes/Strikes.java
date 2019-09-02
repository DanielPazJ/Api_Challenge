package entities.strikes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Strikes {
    @JsonProperty("strikes")
    private Strikes strikes;

    public Strikes getStrikes() {
        return strikes;
    }
}
