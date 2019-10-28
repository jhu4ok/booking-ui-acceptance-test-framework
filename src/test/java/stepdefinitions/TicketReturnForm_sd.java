package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.TicketReturnForm;
import utils.StepUtils;

import static org.junit.Assert.assertTrue;
import static utils.Driver.driver;

public class TicketReturnForm_sd extends StepUtils {

    private TicketReturnForm returnForm = PageFactory.initElements(driver, TicketReturnForm.class);

    @When("^user click the ticket return form \"([^\"]*)\" element$")
    public void user_click_the_ticket_return_form_element(String elementName) {
        returnForm.moveToElementAndClick(returnForm.getTicketReturnFormElement(elementName));
    }

    @Then("^user verify the ticket return form \"([^\"]*)\" element is displayed$")
    public void user_verify_the_ticket_return_form_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" element is not displayed",
                   returnForm.isElementDisplay(returnForm.getTicketReturnFormElement(elementName)));
    }

    @Then("^user verify the ticket return form \"([^\"]*)\" element is not displayed$")
    public void user_verify_the_return_form_element_is_not_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" return form element is not displayed",
                   returnForm.isElementNotDisplay(returnForm.getTicketReturnFormElement(elementName)));
    }

}
