package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import utils.StepUtils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static utils.Driver.driver;

public class HomePage_sd extends StepUtils {

    private HomePage homePage = PageFactory.initElements(driver, HomePage.class);

    @And("^user verify the home page \"([^\"]*)\" element is not displayed$")
    public void user_verify_the_home_page_element_is_not_displayed(String elementName) {
        assertFalse("Expected not displayed \"" + elementName + "\" element is displayed",
                    homePage.isElementDisplay(homePage.getHomePageElement(elementName)));
    }

    @And("^user click on home page \"([^\"]*)\" button$")
    public void user_click_home_page_button(String elementName) {
        homePage.moveToElementAndClick(homePage.getHomePageElement(elementName));
    }

    @When("^user move to home page \"([^\"]*)\" element$")
    public void user_move_to_cinema_page_element(String element) {
        homePage.moveToElement(homePage.getHomePageElement(element));
    }

    @And("^user verify the home page \"([^\"]*)\" element is displayed$")
    public void user_verify_the_home_page_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" home page element is not displayed",
                   homePage.isElementDisplay(homePage.getHomePageElement(elementName)));
    }
}
