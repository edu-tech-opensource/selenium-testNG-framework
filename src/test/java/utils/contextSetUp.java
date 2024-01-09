package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.pageObjectManager;
import java.io.IOException;

public class contextSetUp {

    public WebDriver driver;
    public String product1;
    public pageObjectManager pageObjectManager;
    public TestBase testBase;
    public utils utilities;

    public contextSetUp() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new pageObjectManager(testBase.WebDriverManager());
        utilities = new utils(testBase.WebDriverManager());

    }
}
