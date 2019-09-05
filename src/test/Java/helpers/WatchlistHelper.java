package helpers;

import entities.watchlist.Item;
import entities.watchlist.ItemContent;
import entities.watchlist.Watchlist;

import java.util.ArrayList;
import java.util.List;

public class WatchlistHelper {

    public Watchlist getWatchlistWithSymbol(String name, String symbol){

        Watchlist watchlist = new Watchlist();
        watchlist.setName(name);
        ItemContent itemContent = new ItemContent();
        List<Item> items = new ArrayList<>();
        Item item = new Item();
        item.setSymbol(symbol);
        items.add(item);
        itemContent.setItems(items);
        watchlist.setItemContent(itemContent);

        return watchlist;
    }
}
