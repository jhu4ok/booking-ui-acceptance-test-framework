package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.GeoMenu;
import utils.StepUtils;

import static org.junit.Assert.assertTrue;
import static utils.Driver.driver;

public class GeoMenu_sd extends StepUtils {
    GeoMenu geoMenu = PageFactory.initElements(driver, GeoMenu.class);

    @Then("^user verify the geo menu \"([^\"]*)\" element is displayed$")
    public void user_verify_the_geo_menu_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" geo menu element is not displayed",
                   geoMenu.isElementDisplay(geoMenu.getGeoMenuElement(elementName)));
    }

    @Then("user verify the geo menu is not displayed$")
    public void user_verify_the_geo_menu_is_not_displayed() {
        assertTrue("Expected not displayed geo menu is displayed",
                   geoMenu.isElementNotDisplay(geoMenu.getGeoMenuElement("GEO_MENU")));
    }

    @When("^user click the geo menu \"([^\"]*)\" element$")
    public void user_click_the_geo_menu_element(String elementName) {
        geoMenu.clickOnElement(geoMenu.getGeoMenuElement(elementName));
    }
}
