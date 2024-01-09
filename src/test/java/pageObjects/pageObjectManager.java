package pageObjects;

import org.openqa.selenium.WebDriver;

public class pageObjectManager {

    WebDriver driver;
    public LandingPage landingPage;
    public OffersPage offersPage;
    public LogInPage loginPage;

    public pageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public LandingPage getLandingPage(){
        landingPage = new LandingPage(driver);
        return landingPage;
    }

    public OffersPage offersPage(){
        offersPage = new OffersPage(driver);
        return offersPage;
    }

    public LogInPage loginPage() {
        loginPage = new LogInPage(driver);
        return loginPage;
    }
}
