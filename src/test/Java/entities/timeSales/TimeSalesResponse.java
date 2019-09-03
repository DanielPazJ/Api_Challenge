package entities.timeSales;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeSalesResponse {

    @JsonProperty("series")
    private Series series;

    public Series getSeries() {
        return series;
    }
}

