package entities.timeSales;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Series {

    @JsonProperty("data")
    private List<Data> data;

    public List<Data> getData() {
        return data;
    }
}
