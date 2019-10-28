package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.HelpPage;
import utils.StepUtils;

import static org.junit.Assert.assertTrue;
import static utils.Driver.driver;

public class HelpPage_sd extends StepUtils {

    private HelpPage helpPage = PageFactory.initElements(driver, HelpPage.class);

    private String helpPageUrl = testContext.getBaseUrl() + testContext.getHelpEndpoint();

    @Given("user open help page")
    public void user_open_help_page() {
        helpPage.getWebPage(helpPageUrl);
    }

    @Then("^user validate help page opened$")
    public void user_validate_page() {
        assertTrue("Current URL " + helpPage.getCurrentUrl() + " does not equals expected url " + helpPageUrl,
                   helpPage.getCurrentUrl().equals(helpPageUrl));
    }

    @Then("user validate help page load in time")
    public void user_validate_help_page_load_in_time() {
        helpPage.verifyNavigatedPage("Help");
    }

    @And("^user verify the help page \"([^\"]*)\" element is displayed$")
    public void user_verify_the_help_page_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" help page element is not displayed",
                   helpPage.isElementDisplay(helpPage.getHelpPageElement(elementName)));
    }

    @When("^user click the help page \"([^\"]*)\" element$")
    public void user_click_the_help_page_element(String elementName) {
        helpPage.moveToElementAndClick(helpPage.getHelpPageElement(elementName));
    }

}
