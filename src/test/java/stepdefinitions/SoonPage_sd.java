package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.SoonPage;
import utils.StepUtils;

import static org.junit.Assert.assertTrue;
import static utils.Driver.driver;

public class SoonPage_sd extends StepUtils {

    private SoonPage soonPage = PageFactory.initElements(driver, SoonPage.class);

    private String soonPageUrl = testContext.getBaseUrl() + testContext.getSoonEndpoint();

    @Given("user open soon page")
    public void user_open_soon_page() {
        soonPage.getWebPage(soonPageUrl);
    }

    @Then("^user validate soon page opened$")
    public void user_validate_page() {
        assertTrue("Current URL " + soonPage.getCurrentUrl() + " does not equals expected url " + soonPageUrl,
                   soonPage.getCurrentUrl().equals(soonPageUrl));
    }

    @Then("user validate soon page load in time")
    public void user_validate_cinemas_page_load_in_time() {
        soonPage.verifyNavigatedPage("Soon");
    }

    @And("^user verify the soon page \"([^\"]*)\" element is displayed$")
    public void user_verify_the_soon_page_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" soon page element is not displayed",
                   soonPage.isElementDisplay(soonPage.getSoonPageElement(elementName)));
    }

    @And("^user verify the soon page \"([^\"]*)\" element is not displayed$")
    public void user_verify_the_soon_page_element_is_not_displayed(String elementName) {
        assertTrue("Expected not displayed \"" + elementName + "\" soon page element is displayed",
                   soonPage.isElementNotDisplay(soonPage.getSoonPageElement(elementName)));
    }

    @And("^user verify the soon page \"([^\"]*)\" element is active")
    public void user_verify_the_soon_page_element_is_active(String elementName) {
        assertTrue("Expected active \"" + elementName + "\" soon page element is not active",
                   soonPage.isElementActive(soonPage.getSoonPageElement(elementName)));
    }

    @When("^user click the soon page \"([^\"]*)\" element$")
    public void user_click_the_soon_page_element(String elementName) {
        soonPage.clickOnElement(soonPage.getSoonPageElement(elementName));
    }
}
