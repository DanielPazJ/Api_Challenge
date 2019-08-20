package utils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropiertiesHelper {

    private static Properties properties;
    public void PropertiesHelper() throws IOException {
        FileReader reader = new FileReader("src/test/resources/config/config.properties");
        properties = new Properties();
        properties.load(reader);
    }
    public static String getProperties(String variable) {
        return properties.getProperty(variable);
    }
}