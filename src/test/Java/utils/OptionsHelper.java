package utils;

import entities.expirations.Date;
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
        Double[] strikeContent= {60.0};
        strike.setStrike(strikeContent);
        return strike;
    }

    public Date createOptionExpiration(){
        Date date = new Date();
        String[] dateContent= {"2019-09-06"};
        date.setExpirations(dateContent);
        return date;
    }

}
