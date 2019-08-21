package utils;

public class Utils {

    private static String token;

    public static String readToken() {
          return  token = new PropertiesHelper().getToken();
    }

}
