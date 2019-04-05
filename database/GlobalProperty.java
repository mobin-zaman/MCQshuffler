package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class GlobalProperty {
    Properties properties;
    FileInputStream fileInputStream;

    public GlobalProperty() {
        // initiate fileInputStream
        try {
            fileInputStream = new FileInputStream("/home/terminal/abc/MCQshuffler/global.properties");
        } catch (Exception e) {
            System.out.println("exception: " + e);
        }

        // initiate property
        properties = new Properties();

        try {
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.out.println("exception: " + e);
        }
    }

    public void setProperty(String key, int value) {
        properties.setProperty(key, Integer.toString(value));
        try {
            properties.store(new FileOutputStream("/home/terminal/abc/MCQshuffler/global.properties"), null);
        } catch (Exception e) {
            System.out.println("setProperty(): " + e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
