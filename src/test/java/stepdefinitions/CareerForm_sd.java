package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.CareerForm;
import utils.StepUtils;

import static org.junit.Assert.assertTrue;
import static utils.Driver.driver;

public class CareerForm_sd extends StepUtils {

    private CareerForm careerForm = PageFactory.initElements(driver, CareerForm.class);

    @When("^user click the career form \"([^\"]*)\" element$")
    public void user_click_the_career_form_element(String elementName) {
        careerForm.clickOnElement(careerForm.getCareerFormElement(elementName));
    }

    @Then("^user verify the career form \"([^\"]*)\" element is displayed$")
    public void user_verify_the_career_form_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" main menu element is not displayed",
                   careerForm.isElementDisplay(careerForm.getCareerFormElement(elementName)));
    }
}
