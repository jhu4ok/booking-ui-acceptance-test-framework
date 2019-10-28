package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.AdvertisingForm;
import utils.StepUtils;

import static org.junit.Assert.assertTrue;
import static utils.Driver.driver;

public class AdvertisingForm_sd extends StepUtils {

    private AdvertisingForm advertisingForm = PageFactory.initElements(driver, AdvertisingForm.class);

    @When("^user click the advertising form \"([^\"]*)\" element$")
    public void user_click_the_support_form_element(String elementName) {
        advertisingForm.clickOnElement(advertisingForm.getAdvertisingFormElement(elementName));
    }

    @Then("^user verify the advertising form \"([^\"]*)\" element is displayed$")
    public void user_verify_the_support_form_element_is_displayed(String elementName) {
        assertTrue("Expected displayed \"" + elementName + "\" main menu element is not displayed",
                   advertisingForm.isElementDisplay(advertisingForm.getAdvertisingFormElement(elementName)));
    }

    @And("^user verify the advertising form \"([^\"]*)\" element is not displayed$")
    public void user_verify_the_advertising_form_element_is_not_displayed(String elementName) {
        assertTrue("Expected not displayed \"" + elementName + "\" advertising form element is displayed",
                   advertisingForm.isElementNotDisplay(advertisingForm.getAdvertisingFormElement(elementName)));
    }
}
