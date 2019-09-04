package helpers;

import java.time.LocalDate;

public class DatesHelper {

    public boolean dateIsEqual(String dateInput){
        LocalDate currentDate = LocalDate.now();
        LocalDate date = LocalDate.parse(dateInput);
        return date.isEqual(currentDate);
    }

    public boolean dateIsEqualorBefore(String dateInput){
        LocalDate currentDate = LocalDate.now();
        LocalDate date = LocalDate.parse(dateInput);
        return date.isEqual(currentDate) || dateIsEqual(dateInput);
    }

    public String dateFormatter (String dateInput){
        String[] parts = dateInput.split("T");
        return parts[0].trim();
    }

}
