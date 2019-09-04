package entities.options;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Options {

    @JsonProperty("option")
    private List<Option> option;

    public List<Option> getOption() {
        return option;
    }
}


