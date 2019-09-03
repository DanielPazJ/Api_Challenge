package helpers;

import entities.quotes.Quote;

import java.util.ArrayList;
import java.util.List;

public class QuotesHelper {

    private Quote createQuoteSymbol(Quote quote,String symbol){
        quote.setSymbol(symbol);
        return quote;
    }

    public List<Quote> setQuotesSymbols (String symbols){
        String[] symbolsList = symbols.split(",");
        List<Quote> quotes = new ArrayList<>();
        for (String symbol : symbolsList){
            Quote quote = new Quote();
            quote = createQuoteSymbol(quote,symbol);
            quotes.add(quote);
        }
        return quotes;
    }
}
