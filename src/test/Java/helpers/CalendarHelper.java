package helpers;

import entities.calendar.Calendar;

public class CalendarHelper {

    public Calendar createCalendar(String month, String year){
        Calendar calendar = new Calendar();
        calendar.setMonth(Integer.parseInt(month));
        calendar.setYear(Integer.parseInt(year));
        return calendar;
    }
}
