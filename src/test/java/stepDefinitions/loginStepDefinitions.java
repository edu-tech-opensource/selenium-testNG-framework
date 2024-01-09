package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.LogInPage;
import utils.contextSetUp;

import java.time.Duration;

public class loginStepDefinitions {
    LogInPage login;

    contextSetUp testcontextSetUp;

    public loginStepDefinitions(contextSetUp testcontextSetUp) {
        this.testcontextSetUp = testcontextSetUp;
    }

    ;

    @Given("the user navigates to the landing page")
    public void the_user_navigates_to_the_landing_page() {

    }

    @Then("the user should see the text {string} on the page")
    public void the_user_should_see_the_text_on_the_page(String signInText) throws InterruptedException {
        login = testcontextSetUp.pageObjectManager.loginPage();
        testcontextSetUp.utilities.setImplicitWait(Duration.ofSeconds(5));

        String expectedSignIn = login.getSignInText(signInText);
        Assert.assertEquals("Sign in", expectedSignIn.trim());
    }

    @When("the user enters the username {string} and password {string}")
    public void the_user_enters_the_username_and_password(String username, String password) throws InterruptedException {
        login.userName(username);
        login.passWord(password);

        WebElement button = testcontextSetUp.utilities.waitUntilElementIsClickable(testcontextSetUp.pageObjectManager.loginPage.findSignInButton(), 10);
        button.click();
    }

    @Then("the user should be signed in successfully")
    public void the_user_should_be_signed_in_successfully() {
        WebElement button = testcontextSetUp.utilities.waitUntilElementIsClickable(testcontextSetUp.pageObjectManager.loginPage.closeButton(), 10);
        button.click();

        String projects = login.projects();
        Assert.assertEquals("Projects", projects.trim());

    }

}
