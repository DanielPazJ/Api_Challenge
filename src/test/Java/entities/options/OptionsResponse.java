package entities.options;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OptionsResponse {

    @JsonProperty("options")
    private Options options;

    public Options getOptions() {
        return options;
    }
}
