package pages;

import lombok.Data;
import org.openqa.selenium.*;
import utils.Driver;
import utils.Waiters;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static pages.BasePage.LOG;

@Data
public class GeoWindow {

    private By currentGeo = new By.ByCssSelector(".geo");

    private By acceptLocation = new By.ByCssSelector(".yes");

    private By geoWindow =
        new By.ByCssSelector("body > div.geo_veil.geolocated.desktop-only > div.geo_balloon.geolocated");

    private By otherLocation = new By.ByCssSelector(".other");

    private By geoQuestion = new By.ByCssSelector(".question");

    private By geoMenu = new By.ByCssSelector("body > div.menu.right_menu.animatedlong.slideInUp");

    private WebDriver driver = Driver.getChromeDriver();

    Waiters waiters = new Waiters(driver);

    private static final String QUESTION_UA_REGEX =
        "(Ваше місто - )([а-щА-ЩЬьЮюЯяЇїІіЄєҐґ]*)(, а найближчий кінотеатр - ТРЦ \")(\\w*)";

    public By getGeoWindowLocator(String elementName) {
        By locator = null;
        switch (elementName) {
            case "GEO_WINDOW":
                locator = getGeoWindow();
                break;
            case "GEO_MENU":
                locator = getGeoMenu();
                break;
            case "ACCEPT_LOCATION":
                locator = getAcceptLocation();
                break;
            case "OTHER_LOCATION":
                locator = getOtherLocation();
                break;
            default:
                LOG.error("Unsupported elements type: " + elementName);
        }
        return locator;
    }

    public String getProposedExpectedLocation(String question) {
        Pattern pattern = Pattern.compile(QUESTION_UA_REGEX);
        Matcher matcher = pattern.matcher(question.replace("\n", " "));
        if (matcher.find()) {
            return matcher.group(2) + ", " + matcher.group(4);
        }
        return matcher.find() ? matcher.group(2) + ", " + matcher.group(4) : "";
    }

    public String getOptionalExpectedLocation(String city, String cinema) {
        return city + "," + cinema;
    }

    public void getNewWebPage(String webPage) {
        driver.get(webPage);
    }

    public void waitForPageLoad() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public boolean isElementNotDisplay(WebElement webElement) {
        try {
            return waiters.waitForElementToDisappear(webElement);
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public void clickOnElement(By locator) {
        try {
            waiters.waitForElementToBeClickable(locator).click();
        } catch (WebDriverException e) {
            throw new RuntimeException("Element Not Fount On Page: " + e.getMessage());
        }
    }

    public boolean isElementDisplay(WebElement webElement) {
        try {
            return waiters.waitForElementToBeDisplayed(webElement).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            waiters.waitForElementToBeClickable(element).click();
        } catch (WebDriverException e) {
            throw new RuntimeException("Element Not Fount On Page: " + e.getMessage());
        }
    }

    public WebElement findWebElement(By locator) {
        return waiters.waitForElementToBeDisplayed(locator);
    }

    public WebElement findWebElementNotWait(By locator) {
        return driver.findElement(locator);
    }

    public boolean isElementDisplay(By locator) {
        try {
            return findWebElement(locator).isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }
}

