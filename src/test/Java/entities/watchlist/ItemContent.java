package entities.watchlist;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ItemContent {

    @JsonProperty("item")
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
