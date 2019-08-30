package entities;

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

    public String getDescription() {
        return description;
    }

    public String getExch() {
        return exch;
    }

    public String getType() {
        return type;
    }

    public float getLast() {
        return last;
    }

    public float getChange() {
        return change;
    }

    public long getVolume() {
        return volume;
    }

    public float getOpen() {
        return open;
    }

    public float getHigh() {
        return high;
    }

    public float getLow() {
        return low;
    }

    public String getClose() {
        return close;
    }

    public float getBid() {
        return bid;
    }

    public float getAsk() {
        return ask;
    }

    public float getChangePercentage() {
        return changePercentage;
    }

    public long getAverageVolume() {
        return averageVolume;
    }

    public int getLastVolume() {
        return lastVolume;
    }

    public long getTradeDate() {
        return tradeDate;
    }

    public float getPrevclose() {
        return prevclose;
    }

    public float getWeek52High() {
        return week52High;
    }

    public float getWeek52Low() {
        return week52Low;
    }

    public int getBidsize() {
        return bidsize;
    }

    public String getBidexch() {
        return bidexch;
    }

    public long getBiddate() {
        return biddate;
    }

    public int getAsksize() {
        return asksize;
    }

    public String getAskexch() {
        return askexch;
    }

    public long getAskDate() {
        return askDate;
    }

    public String getRootSymbols() {
        return rootSymbols;
    }
}
