package helpers;

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

    public Date createOptionExpiration(String expirationDate){
        Date date = new Date();
        String[] dateContent = {expirationDate};
        date.setExpirations(dateContent);
        return date;
    }

}
