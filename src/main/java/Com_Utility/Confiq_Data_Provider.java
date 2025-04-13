package Com_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Confiq_Data_Provider {

    private Properties pro;

    // Constructor to load the properties file
    public Confiq_Data_Provider() throws Exception {
        String confiqpath = System.getProperty("user.dir") + File.separator + "Config_TestData" + File.separator + "Confiq.properties";
        
        // Debugging: Print the path to confirm it's correct
        System.out.println("Looking for properties file at: " + confiqpath);

        File f = new File(confiqpath);

        try (FileInputStream file = new FileInputStream(f)) {
            pro = new Properties();
            pro.load(file);
        } catch (FileNotFoundException e) {
            System.err.println("Properties file not found at: " + confiqpath);
            throw e;  // Re-throw the exception or handle accordingly
        } catch (IOException e) {
            System.err.println("Error reading properties file: " + e.getMessage());
            throw e;
        }
    }

    // Generic method to get any property by key
    public String getProperty(String key) {
        return pro.getProperty(key);
    }

    // Specific methods for main credentials
    public String get_BaseURL() {
        return getProperty("Testing_URL");
    }

    public String get_username() {
        return getProperty("UserID");
    }
    
    public String get_password() {
        return getProperty("pass");
    }

    public String get_Browser_name() {
        return getProperty("Browser");
    }
    
    // Specific methods for second credentials
    public String get_username_2() {
        return getProperty("UserID_2");
    }

    public String get_password_2() {
        return getProperty("Pass_2");
    }
}
