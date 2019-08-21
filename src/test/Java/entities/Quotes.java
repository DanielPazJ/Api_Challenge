package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Quotes {

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
    private int volume;
    @JsonProperty("open")
    private float open;
    @JsonProperty("high")
    private float high;
    @JsonProperty("low")
    private float low;
//    @JsonProperty("close")
//    private String close;
    @JsonProperty("bid")
    private float bid;
    @JsonProperty("ask")
    private float ask;
    @JsonProperty("change_percentage")
    private float changePercentage;
    @JsonProperty("average_volume")
    private int averageVolume;
    @JsonProperty("last_volume")
    private int lastVolume;
    @JsonProperty("trade_date")
    private int tradeDate;
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
    private int  biddate;
    @JsonProperty("asksize")
    private int asksize;
    @JsonProperty("askexch")
    private String askexch;
    @JsonProperty("ask_date")
    private int askDate;
    @JsonProperty("root_symbols")
    private String rootSymbols;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExch() {
        return exch;
    }

    public void setExch(String exch) {
        this.exch = exch;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getLast() {
        return last;
    }

    public void setLast(float last) {
        this.last = last;
    }

    public float getChange() {
        return change;
    }

    public void setChange(float change) {
        this.change = change;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getBid() {
        return bid;
    }

    public void setBid(float bid) {
        this.bid = bid;
    }

    public float getAsk() {
        return ask;
    }

    public void setAsk(float ask) {
        this.ask = ask;
    }

    public float getChangePercentage() {
        return changePercentage;
    }

    public void setChangePercentage(float changePercentage) {
        this.changePercentage = changePercentage;
    }

    public int getAverageVolume() {
        return averageVolume;
    }

    public void setAverageVolume(int averageVolume) {
        this.averageVolume = averageVolume;
    }

    public int getLastVolume() {
        return lastVolume;
    }

    public void setLastVolume(int lastVolume) {
        this.lastVolume = lastVolume;
    }

    public int getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(int tradeDate) {
        this.tradeDate = tradeDate;
    }

    public float getPrevclose() {
        return prevclose;
    }

    public void setPrevclose(float prevclose) {
        this.prevclose = prevclose;
    }

    public float getWeek52High() {
        return week52High;
    }

    public void setWeek52High(float week52High) {
        this.week52High = week52High;
    }

    public float getWeek52Low() {
        return week52Low;
    }

    public void setWeek52Low(float week52Low) {
        this.week52Low = week52Low;
    }

    public int getBidsize() {
        return bidsize;
    }

    public void setBidsize(int bidsize) {
        this.bidsize = bidsize;
    }

    public String getBidexch() {
        return bidexch;
    }

    public void setBidexch(String bidexch) {
        this.bidexch = bidexch;
    }

    public int getBiddate() {
        return biddate;
    }

    public void setBiddate(int biddate) {
        this.biddate = biddate;
    }

    public int getAsksize() {
        return asksize;
    }

    public void setAsksize(int asksize) {
        this.asksize = asksize;
    }

    public String getAskexch() {
        return askexch;
    }

    public void setAskexch(String askexch) {
        this.askexch = askexch;
    }

    public int getAskDate() {
        return askDate;
    }

    public void setAskDate(int askDate) {
        this.askDate = askDate;
    }

    public String getRootSymbols() {
        return rootSymbols;
    }

    public void setRootSymbols(String rootSymbols) {
        this.rootSymbols = rootSymbols;
    }

}
