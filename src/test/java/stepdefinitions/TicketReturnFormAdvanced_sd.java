package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.TicketReturnFormAdvanced;
import utils.StepUtils;

import static org.junit.Assert.assertTrue;
import static utils.Driver.driver;

public class TicketReturnFormAdvanced_sd extends StepUtils {

    private TicketReturnFormAdvanced returnForm = PageFactory.initElements(driver, TicketReturnFormAdvanced.class);

    @When("^user click the ticket return advanced form \"([^\"]*)\" element$")
    public void user_click_the_ticket_return_form_element(String elementName) {
        returnForm.clickOnElement(returnForm.getTicketReturnFormElement(elementName));
    }

    @Then("^user verify the ticket return advanced form \"([^\"]*)\" element is displayed$")
    public void user_verify_the_ticket_return_form_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" main menu element is not displayed",
                   returnForm.isElementDisplay(returnForm.getTicketReturnFormElement(elementName)));
    }
}
