package entities.quotes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Quote {

    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("description")
    private String description;
    @JsonProperty("exch")
    private String exch;
    @JsonProperty("type")
    private String type;
    @JsonProperty("last")
    private float last;
    @JsonProperty("change")
    private float change;
    @JsonProperty("volume")
    private long volume;
    @JsonProperty("open")
    private float open;
    @JsonProperty("high")
    private float high;
    @JsonProperty("low")
    private float low;
    @JsonProperty("close")
    private String close;
    @JsonProperty("bid")
    private float bid;
    @JsonProperty("ask")
    private float ask;
    @JsonProperty("change_percentage")
    private float changePercentage;
    @JsonProperty("average_volume")
    private long averageVolume;
    @JsonProperty("last_volume")
    private int lastVolume;
    @JsonProperty("trade_date")
    private long tradeDate;
    @JsonProperty("prevclose")
    private float prevclose;
    @JsonProperty("week_52_high")
    private float week52High;
    @JsonProperty("week_52_low")
    private float week52Low;
    @JsonProperty("bidsize")
    private int bidsize;
    @JsonProperty("bidexch")
    private String bidexch;
    @JsonProperty("bid_date")
    private long  biddate;
    @JsonProperty("asksize")
    private int asksize;
    @JsonProperty("askexch")
    private String askexch;
    @JsonProperty("ask_date")
    private long askDate;
    @JsonProperty("root_symbols")
    private String rootSymbols;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
