package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class TicketBookingPage extends BasePage {

    @FindBy(css = "#ekranInclude")
    WebElement seatsType;

    @FindBy(css = "#ekranInfo")
    WebElement stageInfo;

    @FindBy(css = "#mainDiv")
    WebElement seats;

    @FindBy(css = "#dataRightInfo")
    WebElement dataRightInfo;

    @FindBy(xpath = "//div[@class=\"seat-good-pm\"][1]")
    WebElement goodSeat;

    @FindBy(css = "#button_order_new")
    WebElement continueButton;

    @FindBy(css = "#bar")
    WebElement bar;


    public WebElement getTicketBookingFormElement(String elementName) {
        WebElement webElement = null;
        switch (elementName) {
            case "BAR":
                webElement = getBar();
                break;
            case "SEATS_TYPE":
                webElement = getSeatsType();
                break;
            case "STAGE":
                webElement = getStageInfo();
                break;
            case "SEATS":
                webElement = getSeats();
                break;
            case "DATA_RATING":
                webElement = getDataRightInfo();
                break;
            case "GOOD_SEAT":
                webElement = getGoodSeat();
                break;
            case "CONTINUE_BUTTON":
                webElement = getContinueButton();
                break;
            default:
                LOG.error("Unsupported elements type: " + elementName);
        }
        return webElement;
    }
}
