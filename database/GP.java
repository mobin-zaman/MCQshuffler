package database;

public class GP {

    public static void setProperty(String key, String value) {
        new GlobalProperty().setProperty(key, value);
    }

    public static String getProperty(String key) {
        return new GlobalProperty().getProperty(key);
    }
}