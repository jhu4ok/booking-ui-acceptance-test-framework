package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.FilmDetailsPage;
import utils.StepUtils;

import static junit.framework.TestCase.assertTrue;
import static utils.Driver.driver;

public class FilmDetailsPage_sd extends StepUtils {

    FilmDetailsPage filmDetailsPage = PageFactory.initElements(driver, FilmDetailsPage.class);

    @Then("^user verify the film details page opened$")
    public void user_verify_the_film_details_page_opened() {
        assertTrue(filmDetailsPage.getCurrentUrl().contains(testContext.getFilmEndpoint()));
    }

    @And("^user verify the film page \"([^\"]*)\" element is displayed$")
    public void user_verify_the_film_page_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" film page element is not displayed",
                   filmDetailsPage.isElementDisplay(filmDetailsPage.getFilmPageElement(elementName)));
    }

    @When("^user click the film page \"([^\"]*)\" element$")
    public void user_click_the_film_page_element(String elementName) {
        if (elementName.equals("NEXT_DAY")) {
            context.put("DAY_NAME",
                        filmDetailsPage.getFilmPageElement(elementName).findElement(filmDetailsPage.getDayName()));
            context.put("DAY_DATE",
                        filmDetailsPage.getFilmPageElement(elementName).findElement(filmDetailsPage.getDayDate()));
        }
        filmDetailsPage.moveToElementAndClick(filmDetailsPage.getFilmPageElement(elementName));
    }

    @When("^user move to film page \"([^\"]*)\" element$")
    public void user_move_to_film_page_element(String element) {
        filmDetailsPage.moveToElement(filmDetailsPage.getFilmPageElement(element));
    }

    @When("^user verify selected date is active$")
    public void user_verify_selected_date_is_active() {
        String expectedDayName = filmDetailsPage.getSelector().findElement(filmDetailsPage.getRight()).getText();
        String expectedDayDate = filmDetailsPage.getSelector().findElement(filmDetailsPage.getLeft()).getText();
        assertTrue(
            "Actual day name " + context.get("DAY_NAME") + " does not equals expected day name" + expectedDayName,
            context.get("DAY_NAME").equals(expectedDayName));
        assertTrue(
            "Actual day date " + context.get("DAY_FATE") + " does not equals expected day date" + expectedDayDate,
            context.get("DAY_NAME").equals(expectedDayDate));
    }
}
