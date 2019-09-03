package entities.historicalDates;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Day {

    @JsonProperty("date")
    private String date;
    @JsonProperty("open")
    private long open;
    @JsonProperty("high")
    private long high;
    @JsonProperty("low")
    private long low;
    @JsonProperty("close")
    private long close;
    @JsonProperty("volume")
    private long volume;

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
