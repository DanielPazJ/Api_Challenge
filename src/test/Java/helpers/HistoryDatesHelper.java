package helpers;


import entities.historicalDates.Day;

public class HistoryDatesHelper {

    public Day createOptionExpiration(String date){
        Day day = new Day();
        day.setDate(date);
        return day;
    }
}
