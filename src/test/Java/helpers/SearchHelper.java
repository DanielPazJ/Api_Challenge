package helpers;

import entities.securities.SecuritiesResponse;
import entities.securities.Security;
import utils.Share;
import java.util.List;

public class SearchHelper {

    public boolean validateInformationOf(String validateType) {
        Security security= Share.getShare("security");
        List<Security> securitiesResponse =((SecuritiesResponse)Share.getShare("securityResponse")).getSecurities().getSecurity();

        boolean validInformation = false;

        if (validateType.equals("description")) {
            for (Security value : securitiesResponse)
                if (value.getDescription().toUpperCase().contains(security.getDescription().toUpperCase())) {
                    validInformation = true;
                    break;
                }
        }
        if (validateType.equals("symbol")) {
            for (Security value : securitiesResponse)
                if (value.getSymbol().toUpperCase().contains(security.getSymbol().toUpperCase())) {
                    validInformation = true;
                    break;
                }
        }
        return validInformation;
    }
}
