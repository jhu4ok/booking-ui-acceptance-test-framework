package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.TicketBookingPage;
import utils.StepUtils;

import static org.junit.Assert.assertTrue;
import static utils.Driver.driver;

public class TicketBookingPage_sd extends StepUtils {

    private TicketBookingPage ticketBooking = PageFactory.initElements(driver, TicketBookingPage.class);

    @When("^user click the ticket booking \"([^\"]*)\" element$")
    public void user_click_the_ticket_return_form_element(String elementName) {
        ticketBooking.moveToElementAndClick(ticketBooking.getTicketBookingFormElement(elementName));
    }

    @Then("^user verify the ticket booking \"([^\"]*)\" element is displayed$")
    public void user_verify_the_ticket_return_form_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" ticket booking element is not displayed",
                   ticketBooking.isElementDisplay(ticketBooking.getTicketBookingFormElement(elementName)));
    }

    @Then("^user verify the ticket booking \"([^\"]*)\" element is not displayed$")
    public void user_verify_the_ticket_booking_element_is_not_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" ticket booking element is not displayed",
                   ticketBooking.isElementNotDisplay(ticketBooking.getTicketBookingFormElement(elementName)));
    }

    @Then("^user verify the ticket booking \"([^\"]*)\" element is active")
    public void user_verify_the_ticket_booking_element_is_active(String elementName) {
        assertTrue("Expected active \"" + elementName + "\" ticket booking element is not active",
                   ticketBooking.isElementActive(ticketBooking.getTicketBookingFormElement(elementName)));
    }
}
