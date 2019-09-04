package helpers;

import entities.timeSales.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimesSalesHelper {

    public Data createTimeSalesTime(){
        Data data = new Data();
        String dataContent = "2019-08-30T16:02:00";
        data.setTime(dataContent);
        return data;
    }

    public static String localDateNow(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDate currentDate = LocalDate.now();
        return formatter.format(currentDate);
    }
}
