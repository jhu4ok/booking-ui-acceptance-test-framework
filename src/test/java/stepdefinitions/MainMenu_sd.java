package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.MainMenu;
import utils.StepUtils;

import static org.junit.Assert.assertTrue;
import static utils.Driver.driver;

public class MainMenu_sd extends StepUtils {

    private MainMenu mainMenu = PageFactory.initElements(driver, MainMenu.class);

    @When("^user open the main menu$")
    public void user_open_the_main_menu_element() {
        mainMenu.clickOnElement(mainMenu.getMainMenuButton());
    }

    @When("^user click the main menu \"([^\"]*)\" element$")
    public void user_click_the_main_menu_element(String elementName) {
        mainMenu.moveToElementAndClick(mainMenu.getMainMenuElement(elementName));
    }

    @Then("^user verify the main menu \"([^\"]*)\" element is displayed$")
    public void user_verify_the_main_menu_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" main menu element is not displayed",
                   mainMenu.isElementDisplay(mainMenu.getMainMenuElement(elementName)));
    }

    @Then("^user verify the main menu \"([^\"]*)\" element is active")
    public void user_verify_the_main_menu_element_is_active(String elementName) {
        assertTrue("Expected active \"" + elementName + "\" main menu element is not active",
                   mainMenu.isElementActive(mainMenu.getMainMenuElement(elementName)));
    }
}
