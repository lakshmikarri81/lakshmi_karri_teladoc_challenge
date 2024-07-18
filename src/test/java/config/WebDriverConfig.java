package config;

import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class WebDriverConfig {
    public static final String CHROME_DRIVER;
    public static final String WEB_TABLES_URL;
    static Logger logger = Logger.getLogger(WebDriverConfig.class.getName());

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/properties/setup.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load setup.properties file.");
        }
        logger.info("Setting up ChromeDriver path");
        String osName = System.getProperty("os.name").toLowerCase();
        if(osName.contains("win")){
            CHROME_DRIVER = properties.getProperty("CHROME_DRIVER_WIN");
        }else{
            CHROME_DRIVER = properties.getProperty("CHROME_DRIVER_LUX");
        }
        WEB_TABLES_URL = properties.getProperty("WEB_TABLES_URL");
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return options;
    }
}
