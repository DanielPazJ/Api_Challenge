package helpers;

import entities.quotes.Quote;
import entities.watchlist.Item;
import entities.watchlist.ItemContent;
import entities.watchlist.Watchlist;
import utils.Share;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WatchlistHelper {

    public Watchlist getWatchlistWithSymbol(String name, String symbols){

        Watchlist watchlist = new Watchlist();
        watchlist.setName(name);
        ItemContent itemContent = new ItemContent();

        List<Item> items = new ArrayList<>();
        String[] symbolsList = symbols.split(",");
        for (String symbol : symbolsList){
            Item item = new Item();
            item.setSymbol(symbol);
            items.add(item);
        }

        itemContent.setItems(items);
        watchlist.setItemContent(itemContent);

        return watchlist;
    }

    public boolean verifyWatchlistContainsSymbol(String watchlistKey, String watchlistResponseKey){

        Watchlist watchlist = Share.getShare(watchlistKey);
        Watchlist watchlistResponse = Share.getShare(watchlistResponseKey);

        assertThat(watchlist.getName(), equalTo(watchlistResponse.getName()));

        boolean containsSymbol = false;
        for (int i = 0; i<watchlist.getItemContent().getItems().size();i++) {
            if(watchlist.getItemContent().getItems().get(i).getSymbol()
                    .equals(watchlistResponse.getItemContent().getItems().get(i).getSymbol())) {
                containsSymbol = true;
            }
        }

        return containsSymbol;
    }

    public boolean validateInformationOf(String validateType) {

        Watchlist watchlist = Share.getShare("watchlist");
        Watchlist watchlistResponse = Share.getShare("watchlistResponse");

        boolean validInformation = false;

        if (validateType.equals("id")) {
            if (watchlist.getId().equals(watchlistResponse.getId())){
                validInformation = true;
            }
        }else if (validateType.equals("name")) {
            if (watchlist.getName().equals(watchlistResponse.getName())){
                validInformation = true;
            }
        }
        return validInformation;
    }
}
