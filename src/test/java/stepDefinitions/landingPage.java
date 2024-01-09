package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.contextSetUp;

public class landingPage {
    contextSetUp testcontextSetUp;

    public landingPage(contextSetUp testcontextSetUp) {
        this.testcontextSetUp = testcontextSetUp;
    }

    ;

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
    }

    @When("^User search product using (.+) and extracts actual name of product$")
    public void user_search_product_using_and_extracts_actual_name_of_product(String product) throws InterruptedException {
        LandingPage landingPage = testcontextSetUp.pageObjectManager.getLandingPage();
        landingPage.searchItem(product);
        Thread.sleep(6000);

        testcontextSetUp.product1 = landingPage.getProductName().split("-")[0].trim();
        System.out.println(testcontextSetUp.product1);
    }
}
