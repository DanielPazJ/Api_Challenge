package entities.watchlist;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Watchlist {

    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;
    @JsonProperty("public_id")
    private String publicId;

}