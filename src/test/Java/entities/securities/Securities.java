package entities.securities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Securities {

    @JsonProperty("security")
    private List<Security> security;

    public List<Security> getSecurity() {
        return security;
    }
}
