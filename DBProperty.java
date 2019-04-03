import java.io.FileInputStream;
import java.util.Properties;

public class DBProperty {
    Properties properties;
    FileInputStream fileInputStream;

    public DBProperty()  {
        //initiate fileInputStream
        try {
            fileInputStream = new FileInputStream("/home/terminal/abc/MCQshuffler/src/config.properties");
        } catch (Exception e) {
            System.out.println("exception: " + e);
        }

        //initiate property
        properties = new Properties();

        try {
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.out.println("exception: " + e);
        }
    }

    public String username(){
        return properties.getProperty("username");
    }
    public String password(){
        return properties.getProperty("password");
    }
    public String url(){
        return properties.getProperty("url");
    }

}

