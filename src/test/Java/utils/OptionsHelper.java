package utils;

import entities.options.Option;
import entities.strikes.Strike;

public class OptionsHelper {

    public Option createOptionExpirationDate(String symbol, String expirationDate){
        Option option = new Option();
        option.setRootSymbol(symbol);
        option.setExpirationDate(expirationDate);
        return option;
    }

    public Strike createOptionStrike(){
        Strike strike = new Strike();
        strike.getStrike()[0]= 45.7;
        return strike;
    }

}
