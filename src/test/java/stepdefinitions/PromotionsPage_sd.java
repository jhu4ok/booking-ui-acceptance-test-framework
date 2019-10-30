package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.PromotionsPage;
import utils.StepUtils;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static utils.Driver.driver;

public class PromotionsPage_sd extends StepUtils {

    private PromotionsPage promoPage = PageFactory.initElements(driver, PromotionsPage.class);

    private String promoPageUrl = testContext.getBaseUrl() + testContext.getPromotionsEndpoint();

    @Given("user open promotions page")
    public void user_open_promotions_page() {
        promoPage.getWebPage(promoPageUrl);
    }

    @Then("^user validate promotions page opened$")
    public void user_validate_page() {
        assertTrue("Current URL " + promoPage.getCurrentUrl() + " does not equals expected url " + promoPageUrl,
                   promoPage.getCurrentUrl().equals(promoPageUrl));
    }

    @Then("user validate promotions page load in time")
    public void user_validate_promotions_page_load_in_time() {
        promoPage.verifyNavigatedPage("Promotions");
    }

    @And("^user verify the promotions page \"([^\"]*)\" element is displayed$")
    public void user_verify_the_promotions_page_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" promotions page element is not displayed",
                   promoPage.isElementDisplay(promoPage.getPromoPageElement(elementName)));
    }

    @And("^user verify the promotions page \"([^\"]*)\" elements are present$")
    public void user_verify_the_promotions_page_elements_is_present(String elementName) {
        List<WebElement> promosList = promoPage.findWebElements(promoPage.getPromoPageLocators(elementName));
        for (WebElement element : promosList) {
            assertTrue("Expected displayed \"" + elementName + "\" promotions page element is not displayed",
                       promoPage.isElementPresent(element));
        }
    }

    @When("^user click the promotions page \"([^\"]*)\" element$")
    public void user_click_the_promotions_page_element(String elementName) {
        promoPage.clickOnElement(promoPage.getPromoPageElement(elementName));
    }
}
