package entities.watchlist;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Watchlists {

    @JsonProperty("watchlist")
    private List<Watchlist> watchlistList;

    public List<Watchlist> getWatchlistList() {
        return watchlistList;
    }

    public void setWatchlistList(List<Watchlist> watchlistList) {
        this.watchlistList = watchlistList;
    }
}