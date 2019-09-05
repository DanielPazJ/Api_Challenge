package entities.watchlist;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WatchlistResponse {

    @JsonProperty("watchlists")
    private Watchlists watchlists;

    public Watchlists getWatchlists() {
        return watchlists;
    }

    public void setWatchlists(Watchlists watchlists) {
        this.watchlists = watchlists;
    }
}
