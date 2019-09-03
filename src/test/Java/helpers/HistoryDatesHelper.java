package helpers;


import entities.historicalDates.Day;

public class HistoryDatesHelper {

    public Day createOptionExpiration(){
        Day day = new Day();
        String dayContent = "2019-01-02";
        day.setDate(dayContent);
        return day;
    }
}
