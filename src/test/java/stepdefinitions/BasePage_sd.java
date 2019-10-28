package stepdefinitions;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utils.StepUtils;

import static org.junit.Assert.assertTrue;
import static utils.Driver.driver;

public class BasePage_sd extends StepUtils {

    BasePage basePage = PageFactory.initElements(driver, BasePage.class);

    private String boardPageUrl = testContext.getBaseUrl() + testContext.getBoardEndpoint();

    private Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }
    
    @Given("^user open home page$")
    public void user_navigates_to_home_page() {
        basePage.getWebPage(testContext.getBaseUrl());
        basePage.waitForPageLoad();
    }

    @Then("^user validate board page opened$")
    public void user_validate_page() {
        assertTrue("Current URL " + basePage.getCurrentUrl() + " does not equals expected url " + boardPageUrl,
                   basePage.getCurrentUrl().equals(boardPageUrl));
    }

    @And("^user refresh the page$")
    public void user_refresh_the_page() {
        basePage.refreshPage();
    }

    @Then("^user verify \"([^\"]*)\" element is displayed$")
    public void user_verify_the_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" element is not displayed",
                basePage.isElementDisplay(basePage.getBaseElement(elementName)));
    }

    @Then("^user verify \"([^\"]*)\" element is not displayed$")
    public void user_verify_the_element_is_not_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" element is not displayed",
                basePage.isElementNotDisplay(basePage.getBaseElement(elementName)));
    }

    @When("^user move to \"(last|first)\" poster")
    public void user_move_to_poster(String posterPosition) {
        WebElement element = posterPosition.equals("last")
                ? basePage.getBaseElement("MOVE_TO_RIGHT")
                : basePage.getBaseElement("MOVE_TO_LEFT");
        while (basePage.isElementDisplay(element)) {
            basePage.clickOnElement(element);
        }
    }
}
