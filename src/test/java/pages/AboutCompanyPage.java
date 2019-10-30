package pages;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
@Slf4j
public class AboutCompanyPage extends BasePage {

    @FindBy(css = ".about_left")
    WebElement aboutLeftMenu;

    @FindBy(css = ".about_right")
    WebElement aboutRightMenu;

    @FindBy(css = "#feedback > div > div.support_option.tktback.ticket_return")
    WebElement ticketReturn;

    @FindBy(css = "#feedback > div > div.support_option.support.ct_frm_spt")
    WebElement support;

    @FindBy(css = "#feedback > div > div.support_option.advertising.cl_bk")
    WebElement advertising;

    @FindBy(css = "#feedback > div > div.support_option.kariera.cl_bk")
    WebElement career;

    @FindBy(xpath = "//a[@href='/ua/board']")
    WebElement board;

    @FindBy(css = "body > div.mob_fix_container > div.about_left > div.contents > div:nth-child(2)")
    WebElement feedback;


    public WebElement getAboutCompanyPageElement(String elementName) {
        WebElement webElement = null;
        switch (elementName) {
            case "LEFT_MENU":
                webElement = getAboutLeftMenu();
                break;
            case "RIGHT_MENU":
                webElement = getAboutRightMenu();
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
            case "BOARD":
                webElement = getBoard();
                break;
            case "FEEDBACK":
                webElement = getFeedback();
                break;
            default:
                log.error("Unsupported elements type: " + elementName);
        }
        return webElement;
    }



}
