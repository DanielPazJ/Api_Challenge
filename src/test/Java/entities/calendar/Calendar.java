package entities.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Calendar {

    @JsonProperty("month")
    private int month;
    @JsonProperty("year")
    private int year;
    @JsonProperty("days")
    private Day day;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
