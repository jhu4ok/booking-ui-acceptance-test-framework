package stepdefinitions;

import enums.CityNames;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.GeoMenu;
import utils.StepUtils;

import static org.junit.Assert.assertTrue;

public class GeoMenu_sd extends StepUtils {
    private GeoMenu geoMenu = new GeoMenu();

    @Given("^user open new home page with geo window$")
    public void user_navigates_to_home_page() {
        geoMenu.getNewWebPage(testContext.getBaseUrl());
        geoMenu.waitForPageLoad();
    }

    @Then("^user verify the geo menu \"([^\"]*)\" element is displayed$")
    public void user_verify_the_geo_menu_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" geo menu element is not displayed",
                   geoMenu.isElementDisplay(geoMenu.getGeoMenuElement(elementName)));
    }

    @Then("user verify the geo menu is not displayed$")
    public void user_verify_the_geo_menu_is_not_displayed() {
        assertTrue("Expected not displayed geo menu is displayed",
                   geoMenu.isElementNotDisplay(geoMenu.findWebElement(geoMenu.getGeoMenuElement("GEO_MENU"))));
    }

    @When("^user click the geo menu \"([^\"]*)\" element$")
    public void user_click_the_geo_menu_element(String elementName) {
        geoMenu.clickOnElement(geoMenu.getGeoMenuElement(elementName));
    }

    @When("^user click the geo menu \"([^\"]*)\" city list button$")
    public void user_click_the_geo_menu_city_list_element(String cityName) {
        String locator = String.format(geoMenu.getCityNameSelector(), CityNames.valueOf(cityName).getCityName());
        System.out.println(locator);
        By cityLocator = new By.ByXPath(locator);
        geoMenu.moveToElementAndClick(cityLocator);
    }

    @Then("^user verify \"([^\"]*)\" city list button is active")
    public void user_verify_the_element_is_active(String cityName) {
        String locator = String.format(geoMenu.getCityNameSelectorClass(), CityNames.valueOf(cityName).getCityName());
        System.out.println(locator);
        By cityLocator = new By.ByXPath(locator);
        assertTrue("Expected active \"" + cityName + "\" main menu element is not active",
                   geoMenu.isElementActive(geoMenu.findWebElement(cityLocator)));
    }
}
