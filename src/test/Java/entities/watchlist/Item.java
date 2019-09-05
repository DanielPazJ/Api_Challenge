package entities.watchlist;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("id")
    private String id;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
