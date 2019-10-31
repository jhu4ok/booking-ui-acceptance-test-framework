package pages;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.Driver;
import utils.Waiters;

import java.util.concurrent.TimeUnit;

import static pages.BasePage.LOG;


@Data

public class GeoMenu {

    private By geoSelect = new By.ByCssSelector(".geo_select");

    private By geoMenu = new By.ByCssSelector("body > div.menu.right_menu.animatedlong.slideInUp");

    private By cityList = new By.ByCssSelector(".citylist");

    private By cinemaList = new By.ByCssSelector(".rm_clist");

    private By closeButton = new By.ByCssSelector("div.menu.right_menu.animatedlong.slideInUp > img.menu_close");

    private By otherLocation = new By.ByCssSelector(".other");

    private By geoWindow =
        new By.ByCssSelector("body > div.geo_veil.geolocated.desktop-only > div.geo_balloon.geolocated");

    private String cityNameSelector = "/html/body/div/div/p/span[contains(text(),'%s')]";

    private String cityNameSelectorClass = "/html/body/div/div/p/span[contains(text(),'%s')]/parent::*";

    private WebDriver driver = Driver.getChromeDriver();

    Waiters waiters = new Waiters(driver);

    Actions actions = new Actions(driver);

    public By getGeoMenuElement(String locatorName) {
        By locator = null;
        switch (locatorName) {
            case "OTHER_LOCATION":
                locator = getOtherLocation();
                break;
            case "GEO_WINDOW":
                locator = getGeoWindow();
                break;
            case "GEO_MENU":
                locator = getGeoMenu();
                break;
            case "GEO_SELECT":
                locator = getGeoSelect();
                break;
            case "CITY_LIST":
                locator = getCityList();
                break;
            case "CLOSE_BUTTON":
                locator = getCloseButton();
                break;
            case "CINEMA_LIST":
                locator = getCinemaList();
                break;
            default:
                LOG.error("Unsupported elements type: " + locatorName);
        }
        return locator;
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

    public void moveToElementAndClick(By locator) {
        moveToElement(locator);
        waiters.waitForElementToBeClickable(locator).click();
    }

    public void moveToElement(By locator) {
        actions.moveToElement(findWebElement(locator)).perform();
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

    public boolean isElementActive(WebElement element) {
        try {
            return element.getAttribute("class").contains("active");
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public boolean isElementDisplay(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }
}