package pages;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
@Slf4j
public class AdvertisingForm extends BasePage {

    @FindBy(css = "#feedback > div > div.support_option.advertising.cl_bk")
    WebElement advertisingFeedbackForm;

    @FindBy(css = "body > div.bto.contact_form > div.body_form > form")
    WebElement advertisingForm;

    public WebElement getAdvertisingFormElement(String elementName) {
        WebElement webElement = null;
        switch (elementName) {
            case "ADVERTISING":
                webElement = getAdvertisingForm();
                break;
            case "ADVERTISING_FEEDBACK":
                webElement = getAdvertisingFeedbackForm();
                break;
            default:
                log.error("Unsupported elements type: " + elementName);
        }
        return webElement;
    }
}
