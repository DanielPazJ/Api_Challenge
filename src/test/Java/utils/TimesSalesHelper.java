package utils;

import entities.timeSales.Data;

public class TimesSalesHelper {

    public Data createTimeSalesTime(){
        Data data = new Data();
        String dataContent = "2019-08-30T16:02:00";
        data.setTime(dataContent);
        return data;
    }
}
