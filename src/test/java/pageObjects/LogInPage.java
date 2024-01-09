package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LogInPage {
    public WebDriver driver;

    public LogInPage(WebDriver driver){
        this.driver = driver;
    }

    By signIn = By.xpath("//h1[contains(@class, 'text-center') and contains(text(), 'Sign in')]");
    By username = By.cssSelector("input[type='email']");
    By password = By.cssSelector("input[type='password']");
    By signInButton = By.cssSelector("button[mat-raised-button]");
    By closeButton = By.xpath("//span[@class='mdc-button__label' and text()='Close']");
    By projects = By.xpath("//span[@class='mat-headline-6' and text()='Projects']");

    public void userName(String user){
        driver.findElement(username).sendKeys(user);
    }

    public void passWord(String pass){
        driver.findElement(password).sendKeys(pass);
    }

    public void signInButton(){
        driver.findElement(signInButton).click();
    }

    public String getSignInText(String signInText){
        return driver.findElement(signIn).getText();
    }

    public By findSignInButton() {
        return signInButton;
    }

    public By closeButton() {
        return closeButton;
    }

    public String projects() {
        return driver.findElement(projects).getText();
    }

}
