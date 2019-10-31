package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.GeoWindow;
import utils.StepUtils;

import static org.junit.Assert.assertTrue;

public class GeoWindow_sd extends StepUtils {

    private GeoWindow geoWindow = new GeoWindow();

    @Given("^user open home page with geo window$")
    public void user_navigates_to_home_page() {
        geoWindow.getNewWebPage(testContext.getBaseUrl());
        geoWindow.waitForPageLoad();
    }

    @And("^user accept geo location$")
    public void user_accept_geo_location() {
        try {
            if (geoWindow.findWebElementNotWait(geoWindow.getAcceptLocation()).isDisplayed()) {
                context.put("QUESTION", geoWindow.findWebElement(geoWindow.getGeoQuestion()).getText());
                geoWindow.clickOnElement(geoWindow.getAcceptLocation());
            }
        } catch (NoSuchElementException e) {
        }
    }

    @Then("^user verify \"(PROPOSED|OPTIONAL)\" location is selected$")
    public void user_verify_location_is_selected(String locationType) {
        String actualLocation = geoWindow.findWebElement(geoWindow.getCurrentGeo()).getText();
        String expectedLocation;
        if (locationType.equals("PROPOSED")) {
            expectedLocation = geoWindow.getProposedExpectedLocation((String) context.get("QUESTION"));
        } else {
            expectedLocation =
                geoWindow.getOptionalExpectedLocation((String) context.get("CITY"), (String) context.get("CINEMA"));
        }
        assertTrue(
            "Actual location \"" + actualLocation + "\" does not match expected location \"" + expectedLocation + "\"",
            actualLocation.equals(expectedLocation));
    }

    @And("^user verify the geo window \"([^\"]*)\" element is displayed$")
    public void user_verify_the_home_page_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" geo window element is not displayed",
                   geoWindow.isElementDisplay(geoWindow.getGeoWindowLocator(elementName)));
    }

    @When("^user click the geo window \"([^\"]*)\" element$")
    public void user_click_the_geo_window_element(String elementName) {
        geoWindow.clickOnElement(geoWindow.findWebElement(geoWindow.getGeoWindowLocator(elementName)));
    }

    @And("^user click on geo window other location button$")
    public void user_click_home_page_button() {
        geoWindow.clickOnElement(geoWindow.getOtherLocation());
    }
}
