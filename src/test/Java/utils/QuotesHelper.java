package utils;

import entities.Quote;

public class QuotesHelper {

    public static Quote createQuoteSymbol(Quote quote,String symbol){
        quote.setSymbol(symbol);
        return quote;
    }
}
