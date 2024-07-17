package config;

import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverConfig {
    public static final String CHROME_DRIVER_PATH;
    public static final String WEB_TABLES_URL;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/properties/setup.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load setup.properties file.");
        }
        CHROME_DRIVER_PATH = properties.getProperty("CHROME_DRIVER_PATH");
        WEB_TABLES_URL = properties.getProperty("WEB_TABLES_URL");
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return options;
    }
}
