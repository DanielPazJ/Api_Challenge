package utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.io.IOException;


public class MapperHelper {

    private static ObjectMapper mapper  = new ObjectMapper();

    public static void setMapper(Response response, String key, Class type) {
        try {
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            Share.setShare(key,mapper.readValue(response.getBody().asString(), type));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
