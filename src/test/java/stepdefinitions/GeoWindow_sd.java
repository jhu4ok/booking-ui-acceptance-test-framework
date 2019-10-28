package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.GeoWindow;
import utils.StepUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;
import static utils.Driver.driver;

public class GeoWindow_sd extends StepUtils {

    private static final String QUESTION_UA_REGEX =
        "(Ваше місто - )([а-щА-ЩЬьЮюЯяЇїІіЄєҐґ]*)(, а найближчий кінотеатр - ТРЦ \")(\\w*)";

    private GeoWindow geoWindow = PageFactory.initElements(driver, GeoWindow.class);

    @Given("^user open home page with geo window$")
    public void user_navigates_to_home_page() {
        geoWindow.getNewWebPage(testContext.getBaseUrl());
        geoWindow.waitForPageLoad();
    }

    @And("^user accept geo location$")
    public void user_accept_geo_location() {
        try {
            if (geoWindow.getAcceptLocation().isDisplayed()) {
                context.put("QUESTION", geoWindow.getGeoQuestion().getText());
                geoWindow.clickOnElement(geoWindow.getAcceptLocation());
            }
        } catch (NoSuchElementException e) {
        }
    }

    @Then("^user verify \"(proposed|optional)\" location is selected$")
    public void user_verify_location_is_selected(String locationType) {
        String actualLocation = geoWindow.findWebElement(geoWindow.getCurrentGeo()).getText();
        String expectedLocation;
        if (locationType.equals("proposed")) {
            expectedLocation = getProposedExpectedLocation();
        } else {
            expectedLocation = getOptionalExpectedLocation();
        }
        assertTrue(
            "Actual location \"" + actualLocation + "\" does not match expected location \"" + expectedLocation + "\"",
            actualLocation.equals(expectedLocation));
    }

    @And("^user verify the geo window \"([^\"]*)\" element is displayed$")
    public void user_verify_the_home_page_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" geo window element is not displayed",
                   geoWindow.isElementDisplay(getGeoWindowElement(elementName)));
    }

    @When("^user click the geo window \"([^\"]*)\" element$")
    public void user_click_the_geo_window_element(String elementName) {
        geoWindow.clickOnElement(getGeoWindowElement(elementName));
    }
    @And("^user click on geo window other location button$")
    public void user_click_home_page_button() {
        geoWindow.clickOnElement(geoWindow.getOtherLocation());
    }

    private WebElement getGeoWindowElement(String elementName) {
        WebElement webElement = null;
        switch (elementName) {
            case "GEO_WINDOW":
                webElement = geoWindow.getGeoWindow();
                break;
            case "ACCEPT_LOCATION":
                webElement = geoWindow.getAcceptLocation();
                break;
            case "OTHER_LOCATION":
                webElement = geoWindow.getOtherLocation();
                break;
            default:
                LOG.error("Unsupported elements type: " + elementName);
        }
        return webElement;
    }
    private String getProposedExpectedLocation() {
        Pattern pattern = Pattern.compile(QUESTION_UA_REGEX);
        Matcher matcher = pattern.matcher(((String) context.get("QUESTION")).replace("\n", " "));
        if (matcher.find()) {
            return matcher.group(2) + ", " + matcher.group(4);
        }
        return matcher.find() ? matcher.group(2) + ", " + matcher.group(4) : "";
    }

    private String getOptionalExpectedLocation() {
        return context.get("CITY") + "," + context.get("CINEMA");
    }
}
