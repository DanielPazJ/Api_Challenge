package entities.expirations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Date {

    @JsonProperty("date")
    private String[] expirations;

    public String[] getExpirations() {
        return expirations;
    }

    public void setExpirations(String[] expirations) {
        this.expirations = expirations;
    }
}
