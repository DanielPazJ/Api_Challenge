package entities.securities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecuritiesResponse {

    @JsonProperty("securities")
    private Securities securities;

    public Securities getSecurities() {
        return securities;
    }
}
