package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
        Properties prop = new Properties();
        prop.load(file);
        String url = prop.getProperty("testURL");
        String browser_properties = prop.getProperty("browser");
        String browser_maven = System.getProperty("browser");
        String browser = browser_maven!=null ? browser_maven : browser_properties;

        if(driver == null) {
            if (browser.equalsIgnoreCase( "chrome")){
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//test//resources//geckodriver");
            driver = new ChromeDriver();
        }if(browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//test//resources//geckodriver");
                driver = new FirefoxDriver();
        }
        driver.get(url);
    }
        return driver;
    }

}
