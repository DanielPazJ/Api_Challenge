package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {

    private String property = null;

    public  String getProperty(String propertyName) {
        try {
            InputStream fileInput = new FileInputStream("src/test/resources/config/config.properties");
            Properties properties = new Properties();
            properties.load(fileInput);
            property = properties.getProperty(propertyName);
            fileInput.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return property;
    }

    public  String getToken(){

        return getProperty("token");
    }

}