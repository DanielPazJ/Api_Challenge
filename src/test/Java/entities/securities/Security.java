package entities.securities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Security {

    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("exchange")
    private String exchange;
    @JsonProperty("type")
    private String stock;
    @JsonProperty("description")
    private String description;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
