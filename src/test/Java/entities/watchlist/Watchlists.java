package entities.watchlist;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Watchlists {

    @JsonProperty("watchlist")
    private List<Watchlist> watchlistList;
}