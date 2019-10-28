package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.AboutCompanyPage;
import utils.StepUtils;

import static org.junit.Assert.assertTrue;
import static utils.Driver.driver;

public class AboutCompanyPage_sd extends StepUtils {

    private AboutCompanyPage aboutCompanyPage = PageFactory.initElements(driver, AboutCompanyPage.class);

    private String aboutCompanyUrl = testContext.getBaseUrl() + testContext.getAboutEndpoint();

    @Given("user open about company page")
    public void user_open_about_company_page() {
        aboutCompanyPage.getWebPage(aboutCompanyUrl);
    }

    @Then("^user validate about company page opened$")
    public void user_validate_page() {
        assertTrue("Current URL " + aboutCompanyPage.getCurrentUrl() + " does not equals expected url " + aboutCompanyUrl,
                aboutCompanyPage.getCurrentUrl().equals(aboutCompanyUrl));
    }

    @Then("user validate about company page load in time")
    public void user_validate_about_company_page_load_in_time() {
        aboutCompanyPage.verifyNavigatedPage("About Company");
    }

    @Then("^user verify the about company page \"([^\"]*)\" element is displayed$")
    public void user_verify_the_about_company_page_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" about page element is not displayed",
                aboutCompanyPage.isElementDisplay(aboutCompanyPage.getAboutCompanyPageElement(elementName)));
    }

    @When("^user click the about company page \"([^\"]*)\" element$")
    public void user_click_the_about_company_page_element(String elementName) {
        aboutCompanyPage.moveToElementAndClick(aboutCompanyPage.getAboutCompanyPageElement(elementName));
    }
}
