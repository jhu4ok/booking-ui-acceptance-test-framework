package pages;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
@Slf4j
public class HelpPage extends BasePage {

    @FindBy(css = ".faq-container")
    WebElement faqContainer;

    @FindBy(css = "body > div.mob_fix_container.faq-container--page > div > div.faq-container--bottom > div > div")
    WebElement askButton;

    @FindBy(css = ".faq-bottom-phone")
    WebElement phoneButton;

    @FindBy(css = ".support_options")
    WebElement supportOptions;

    @FindBy(css = ".ticket_return")
    WebElement ticketReturn;

    @FindBy(css = ".ct_frm_spt")
    WebElement support;

    @FindBy(css = "div.support_option.advertising.cl_bk")
    WebElement advertising;

    @FindBy(css = "div.support_option.kariera.cl_bk")
    WebElement career;

    public WebElement getHelpPageElement(String elementName) {
        WebElement webElement = null;
        switch (elementName) {
            case "ASK":
                webElement = getAskButton();
                break;
            case "SUPPORT_OPTIONS":
                webElement = getSupportOptions();
                break;
            case "RIGHT_MENU":
                webElement = getFaqContainer();
                break;
            case "PHONE_BUTTON":
                webElement = getPhoneButton();
                break;
            case "TICKET_RETURN":
                webElement = getTicketReturn();
                break;
            case "SUPPORT":
                webElement = getSupport();
                break;
            case "ADVERTISING":
                webElement = getAdvertising();
                break;
            case "CAREER":
                webElement = getCareer();
                break;
            default:
                log.error("Unsupported elements type: " + elementName);
        }
        return webElement;
    }


}
