package pages;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
@Slf4j
public class TicketReturnFormAdvanced extends BasePage {

    @FindBy(css = "body > div.bto.refund_form.nad > div.body_form")
    WebElement returnFormAdvanced;

    public WebElement getTicketReturnFormElement(String elementName) {
        WebElement webElement = null;
        switch (elementName) {
            case "TICKET_RETURN_ADVANCED":
                webElement = getReturnFormAdvanced();
                break;
            default:
                log.error("Unsupported ticket return form elements type: " + elementName);
        }
        return webElement;
    }
}
