package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.contextSetUp;

public class offerPage {

    String offerPageProductName;
    contextSetUp testcontextSetUp;
    public offerPage(contextSetUp testcontextSetUp){
        this.testcontextSetUp= testcontextSetUp;
    };

    @Then("^User search (.+) in offers page if product product exists$")
    public void user_search_in_offers_page_if_product_product_exists(String product) throws InterruptedException {
        switchToOffersPage();
        OffersPage offersPage = testcontextSetUp.pageObjectManager.offersPage();
        Thread.sleep(6000);

        offersPage.searchItem(product);
        Thread.sleep(6000);
        offerPageProductName = offersPage.getProductName();
        Thread.sleep(6000);

    }

    @Then("Validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() {
        Assert.assertEquals(testcontextSetUp.product1, offerPageProductName);
    }

    public void switchToOffersPage(){
        LandingPage landingPage = testcontextSetUp.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        testcontextSetUp.utilities.switchWindowToChild();
    }

}
