package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuotesResponse {

    @JsonProperty("quotes")
    private Quotes quotes;
}
