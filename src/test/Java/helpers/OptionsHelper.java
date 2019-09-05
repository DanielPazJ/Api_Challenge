package helpers;

import entities.expirations.Date;
import entities.expirations.Expirations;
import entities.options.Option;
import entities.options.OptionsResponse;
import entities.strikes.Strike;
import entities.strikes.Strikes;
import utils.Share;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class OptionsHelper {

    public Option createOptionExpirationDate(String symbol, String expirationDate) {
        Option option = new Option();
        option.setRootSymbol(symbol);
        option.setExpirationDate(expirationDate);
        return option;
    }

    public Strike createOptionStrike() {
        Strike strike = new Strike();
        Double[] strikeContent = {60.0};
        strike.setStrike(strikeContent);
        return strike;
    }

    public Date createOptionExpiration(String expirationDate) {
        Date date = new Date();
        String[] dateContent = {expirationDate};
        date.setExpirations(dateContent);
        return date;
    }

    public boolean verifyQuotesContainsExpirationDateOnly(String optionsKey, String optionsResponseKey) {
        Option options = Share.getShare(optionsKey);
        List<Option> optionResponse = ((OptionsResponse) Share.getShare(optionsResponseKey)).getOptions().getOption();
        boolean containsRootSymbol = false;
        boolean containsExpirationDate = false;
        for (Option option : optionResponse) {
            if (option.getRootSymbol()
                    .equals(options.getRootSymbol())) {
                containsRootSymbol = true;
            }
        }
        if (containsRootSymbol = true) {
            for (Option option : optionResponse) {
                if (option.getExpirationDate()
                        .equals(options.getExpirationDate())) {
                    containsExpirationDate = true;
                }
            }
        }
        return containsExpirationDate;
    }

    public boolean verifyStrikesContainsExpirationDateOnly(String strikeKey, String strikesResponseKey) {
        Strike strike = Share.getShare(strikeKey);
        Double[] strikeResponse = ((Strikes)Share.getShare(strikesResponseKey)).getStrikes().getStrike();
        boolean containsExpirationDate = false;
        for (Double aDouble : strikeResponse) {
            if (strike.getStrike()[0].equals(aDouble)) {
                containsExpirationDate = true;
            }
        }
        return containsExpirationDate;

    }

    public boolean verifyContainsExpirationDate(String expirationDate,String expirationsResponseKey) {
        String[] expirationDateResponse = ((Expirations)Share.getShare(expirationsResponseKey))
                .getDates().getExpirations();
        assertThat(expirationDate,equalTo(expirationDateResponse[0]));
        boolean containsExpirationDate = false;
        for (String aString : expirationDateResponse) {
            if (expirationDate.equals(aString)) {
                containsExpirationDate = true;
            }
        }
        return containsExpirationDate;

    }


}
