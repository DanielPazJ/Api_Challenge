package entities.watchlist;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Watchlist {

    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;
    @JsonProperty("public_id")
    private String publicId;
    @JsonProperty("items")
    private ItemContent itemContent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ItemContent getItemContent() {
        return itemContent;
    }

    public void setItemContent(ItemContent itemContent) {
        this.itemContent = itemContent;
    }
}