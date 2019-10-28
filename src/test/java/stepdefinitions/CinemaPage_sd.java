package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.CinemaPage;
import utils.StepUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utils.Driver.driver;

public class CinemaPage_sd extends StepUtils {

    private CinemaPage cinemaPage = PageFactory.initElements(driver, CinemaPage.class);

    @When("^user click the cinema page \"([^\"]*)\" element$")
    public void user_click_the_cinema_page_element(String elementName) {
        cinemaPage.clickOnElement(cinemaPage.getCinemaPageElement(elementName));
    }

    @Then("^user verify the cinema page \"([^\"]*)\" element is displayed$")
    public void user_verify_the_cinema_page_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" cinema details element is not displayed",
                   cinemaPage.isElementDisplay(cinemaPage.getCinemaPageElement(elementName)));
    }

    @Then("^user verify the cinema page \"([^\"]*)\" elements contain \"([^\"]*)\"$")
    public void user_verify_the_cinema_page_elements_contains_nested_element(String parentElementName,
                                                                             String nestedElementName) {
        List<WebElement> parentElements =
            cinemaPage.findWebElements(cinemaPage.getCinemaPageLocator(parentElementName));
        for (WebElement element : parentElements) {
            WebElement nestedElement = element.findElement(cinemaPage.getCinemaPageLocator(nestedElementName));
            assertTrue("Expected displayed \"" + nestedElementName + "\" cinema details element is not displayed",
                       cinemaPage.isElementDisplay(nestedElement));
        }
    }

    @Then("^user verify the cinema page opened$")
    public void user_verify_the_cinema_page_opened() {
        assertTrue(cinemaPage.getCurrentUrl().contains(testContext.getCinemaEndpoint()));
    }

    @Then("^user verify the cinema page schedule date elements contain \"([^\"]*)\"$")
    public void user_verify_the_cinema_page_date_elements_contains_nested_element(String nestedElementName) {
        List<WebElement> dateElements = cinemaPage.findWebElements(cinemaPage.getCinemaPageLocator("SCHEDULE_DATE"));
        for (WebElement element : dateElements) {
            if (element.isDisplayed()) {
                WebElement nestedElement = element.findElement(cinemaPage.getCinemaPageLocator(nestedElementName));
                assertTrue(
                    "Expected displayed \"" + nestedElementName + "\" cinema details schedule element is not displayed",
                    cinemaPage.isElementDisplay(nestedElement));
            }
        }
    }

    @Then("^user verify the cinema page schedule date value is correct")
    public void user_verify_the_cinema_page_date_elements_contains_correct_date() {
        List<WebElement> dateElements = cinemaPage.findWebElements(cinemaPage.getCinemaPageLocator("SCHEDULE_DATE"));
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
        Date date = new Date();
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        for (WebElement element : dateElements) {
            if (element.isDisplayed()) {
                String expectedDate = formatter.format(calendar.getTime());
                assertTrue(
                    "Actual date " + element.getAttribute("data-date") + " does not much expected date " + expectedDate,
                    element.getAttribute("data-date").contains(expectedDate));
                calendar.add(Calendar.DAY_OF_YEAR, 1);
            }
        }
    }

    @Then("^user verify the cinema page \"([^\"]*)\" element is active")
    public void user_verify_the_cinema_page_element_is_active(String elementName) {
        assertTrue("Expected active \"" + elementName + "\" cinema page element is not active",
                   cinemaPage.isElementActive(cinemaPage.getCinemaPageElement(elementName)));
    }

    @Then("^user verify the cinema page \"([^\"]*)\" element is selected")
    public void user_verify_the_cinema_page_element_is_selected(String elementName) {
        assertTrue("Expected active \"" + elementName + "\" cinema page e element is not active",
                   cinemaPage.isElementSelected(cinemaPage.getCinemaPageElement(elementName)));
    }


    @Then("^user verify the cinema details \"([^\"]*)\" elements are displayed$")
    public void user_verify_the_cinema_page_elements_is_displayed(String elementName) {
        List<WebElement> elementsList = cinemaPage.findWebElements(cinemaPage.getCinemaPageLocator(elementName));
        for (WebElement element : elementsList) {
            assertTrue("Expected displayed \"" + elementName + "\" cinema page element is not displayed",
                       cinemaPage.isElementDisplay(element));
        }
    }

    @When("^user move to cinema page \"([^\"]*)\" element$")
    public void user_move_to_cinema_page_element(String element) {
        cinemaPage.moveToElement(cinemaPage.getCinemaPageElement(element));
    }

    @And("^displayed films related \"([^\"]*)\" filter$")
    public void displayed_films_related_filter(String filterOption) {
        List<WebElement> filmElements =
            cinemaPage.findWebElements(cinemaPage.getCinemaPageLocator("ACTIVE_FILMS_SESSIONS_TIME"));
        if (!filmElements.isEmpty()) {
            for (WebElement element : filmElements) {
                if (element.isDisplayed()) {
                    assertTrue(
                        "Actual displayed film session time does not contain expected filter option " + filterOption,
                        element.getAttribute("data-attributes").contains(filterOption));
                }
            }
        }
    }

    @Then("^user verify the cinema page \"([^\"]*)\" hint is displayed$")
    public void user_verify_the_cinema_page_hint_is_displayed(String element) {
        assertTrue("Expected displayed \"" + element + "\" hint  is not displayed", cinemaPage.isElementDisplay(
            cinemaPage.getCinemaPageElement(element).findElement(cinemaPage.getCinemaPageLocator("FILTER_HINT"))));
    }
}