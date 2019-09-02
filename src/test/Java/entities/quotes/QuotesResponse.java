package entities.quotes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuotesResponse {

    @JsonProperty("quotes")
    private Quotes quotes;

    public Quotes getQuotes() {
        return quotes;
    }
}
