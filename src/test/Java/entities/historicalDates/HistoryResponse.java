package entities.historicalDates;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HistoryResponse {

    @JsonProperty("history")
    private History dates;

    public History getDates() {
        return dates;
    }
}
