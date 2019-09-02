package entities.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.quotes.Quotes;

public class OptionsResponse {

    @JsonProperty("options")
    private Options options;

    public Options getOptions() {
        return options;
    }
}
