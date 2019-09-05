package helpers;

import entities.expirations.Date;
import entities.options.Option;
import entities.options.OptionsResponse;
import entities.strikes.Strike;
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
        assertThat(options.getRootSymbol(), equalTo(optionResponse.get(0).getRootSymbol()));
        assertThat(options.getExpirationDate(), equalTo(optionResponse.get(0).getExpirationDate()));

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
}
