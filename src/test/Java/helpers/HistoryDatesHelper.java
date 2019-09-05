package helpers;

import entities.historicalDates.Day;
import entities.historicalDates.HistoryResponse;
import utils.Share;
import java.util.List;

public class HistoryDatesHelper {

    public Day createOptionExpiration(String date){
        Day day = new Day();
        day.setDate(date);
        return day;
    }

    public boolean verifyHistoricalContainsDay(String historicalDayKey, String historyResponseKey){

        Day historicalDate = Share.getShare(historicalDayKey);
        List<Day> historicalResponse = ((HistoryResponse)Share.getShare(historyResponseKey)).getDates().getDays();

        boolean containsDate = false;
        for (Day day : historicalResponse) {
            if (historicalDate.getDate().equals(day.getDate())) {
                containsDate = true;
            }
        }
        return containsDate;
    }
}
