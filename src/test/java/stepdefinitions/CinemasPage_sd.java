package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.CinemasPage;
import utils.StepUtils;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static utils.Driver.driver;

public class CinemasPage_sd extends StepUtils {

    private CinemasPage cinemasPage = PageFactory.initElements(driver, CinemasPage.class);

    private String cinemasPageUrl = testContext.getBaseUrl() + testContext.getCinemasEndpoint();

    @Given("user open cinemas page")
    public void user_open_cinemas_page() {
        cinemasPage.getWebPage(cinemasPageUrl);
    }

    @Then("^user validate cinemas page opened$")
    public void user_validate_page() {
        assertTrue("Current URL " + cinemasPage.getCurrentUrl() + " does not equals expected url " + cinemasPageUrl,
                   cinemasPage.getCurrentUrl().equals(cinemasPageUrl));
    }

    @Then("user validate cinemas page load in time")
    public void user_validate_cinemas_page_load_in_time() {
        cinemasPage.verifyNavigatedPage("Cinemas");
    }

    @And("^user verify the cinemas page \"([^\"]*)\" element is displayed$")
    public void user_verify_the_cinemas_page_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" cinema page element is not displayed",
                   cinemasPage.isElementDisplay(cinemasPage.getCinemasPageElement(elementName)));
    }

    @When("^user click the cinemas page \"([^\"]*)\" element$")
    public void user_click_the_cinemas_page_element(String elementName) {
        if (elementName.equals("DROP_DOWN_CITY")) {
            context.put("FILTER", cinemasPage.getCinemasPageElement(elementName).getText());
        }
        cinemasPage.clickOnElement(cinemasPage.getCinemasPageElement(elementName));
    }

    @When("^user click the cinemas page map \"([^\"]*)\" element$")
    public void user_click_the_cinemas_page_map_element(String cityName) {
        cinemasPage.clickOnElement(new By.ByCssSelector(String.format(cinemasPage.getCityOnMap(), cityName)));
    }

    @Then("^user validate the cinemas \"([^\"]*)\" page opened$")
    public void user_validate_page(String cityName) {
        assertTrue("Current URL " + cinemasPage.getCurrentUrl() + " does not equals expected url ",
                   cinemasPage.getCurrentUrl().contains(cityName));
    }

    @Then("^user verify the cinemas page \"([^\"]*)\" elements are displayed$")
    public void user_verify_the_cinemas_page_elements_is_displayed(String elementName) {
        List<WebElement> elementsList = cinemasPage.findWebElements(cinemasPage.getCinemasPageLocator(elementName));
        for (WebElement element : elementsList) {
            assertTrue("Expected displayed \"" + elementName + "\" cinemas page element is not displayed",
                       cinemasPage.isElementDisplay(element));
        }
    }

    @And("^user validate cinemas related \"([^\"]*)\" filter$")
    public void displayed_films_related_filter(String filterOption) {
        List<WebElement> filmElements = cinemasPage.findWebElements(cinemasPage.getCinema());
        for (WebElement element : filmElements) {
            if (element.isDisplayed()) {
                if (filterOption.equals("DROP_DOWN_CITY")) {
                    if (element.isDisplayed()) {
                        assertTrue("Actual displayed cinema does not related filter option: " + filterOption,
                                   element.findElement(cinemasPage.getCityName()).getText()
                                          .equals(context.get("FILTER")));
                    }
                } else {
                    assertTrue("Actual displayed cinema does not related filter option: " + filterOption,
                               element.getAttribute(cinemasPage.getCinemaAttribute(filterOption)).contains("true"));
                }
            }
        }
    }

    @Then("^user verify the cinemas page \"([^\"]*)\" element is selected")
    public void user_verify_the_cinemas_page_element_is_selected(String elementName) {
        assertTrue("Expected active \"" + elementName + "\" cinemas page element is not active",
                   cinemasPage.isElementChecked(cinemasPage.getCinemasPageElement(elementName)));
    }

    @Then("^user verify the cinemas page cinema list \"([^\"]*)\" is displayed$")
    public void user_verify_the_cinemas_page_cinema_list_is_displayed(String elementName) {
        List<WebElement> parentElements = cinemasPage.findWebElements(cinemasPage.getCinema());
        for (WebElement element : parentElements) {
            WebElement nestedElement = element.findElement(cinemasPage.getCinemasPageLocator(elementName));
            assertTrue("Expected displayed \"" + elementName + "\" cinema details element is not displayed",
                       cinemasPage.isElementDisplay(nestedElement));
        }
    }
}
