package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {

    private static String token= null;

    public static String testtoken() {
        try {
            InputStream fileInput = new FileInputStream("src/test/resources/config/config.properties");
            Properties properties = new Properties();
            properties.load(fileInput);
            token = properties.getProperty("token");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return token;
    }

    public  String getToken(){

        try {
            InputStream fileInput = new FileInputStream("src/test/resources/config/config.properties");
            Properties properties = new Properties();
            properties.load(fileInput);
            token = properties.getProperty("token");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return token;
    }


}