package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.FeedbackForm;
import utils.StepUtils;

import static org.junit.Assert.assertTrue;
import static utils.Driver.driver;

public class FeedbackForm_sd extends StepUtils {

    private FeedbackForm feedbackForm = PageFactory.initElements(driver, FeedbackForm.class);

    @When("^user click the feedback form \"([^\"]*)\" element$")
    public void user_click_the_support_form_element(String elementName) {
        feedbackForm.clickOnElement(feedbackForm.getFeedbackFormElement(elementName));
    }

    @Then("^user verify the feedback form \"([^\"]*)\" element is displayed$")
    public void user_verify_the_support_form_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" feedback form element is not displayed",
                   feedbackForm.isElementDisplay(feedbackForm.getFeedbackFormElement(elementName)));
    }

    @And("^user verify the feedback form \"([^\"]*)\" element is not displayed$")
    public void user_verify_the_feedback_form_element_is_not_displayed(String elementName) {
        assertTrue("Expected not displayed \"" + elementName + "\" feedback form element is displayed",
                   feedbackForm.isElementNotDisplay(feedbackForm.getFeedbackFormElement(elementName)));
    }
}
