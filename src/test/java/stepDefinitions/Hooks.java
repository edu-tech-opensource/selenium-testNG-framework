package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.contextSetUp;

import java.io.File;
import java.io.IOException;

public class Hooks {
    contextSetUp testContextSetUp;
    public Hooks(contextSetUp testContextSetUp){
        this.testContextSetUp = testContextSetUp;
    }

    @After
    public void AfterScenario(){
        testContextSetUp.testBase.driver.quit();
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
        WebDriver driver = testContextSetUp.testBase.WebDriverManager();
        if(scenario.isFailed()){
            File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);// convert to byte format
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);

            scenario.attach(fileContent,"image/png", "failed image");
        }}

}
