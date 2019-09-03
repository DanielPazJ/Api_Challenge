package entities.strikes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Strike {

    @JsonProperty("strike")
    private Double[] strike;

    public Double[] getStrike() {
        return strike;
    }
    public void setStrike(Double[] strike) {
        this.strike = strike;
    }
}
