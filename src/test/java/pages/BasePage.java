package pages;


import com.google.common.collect.ImmutableMap;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.Driver;
import utils.Waiters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Data
@Slf4j
public class BasePage {
    protected Map<String, String> pageNavigationMenus = new HashMap<>();

    WebDriver driver = new Driver().getDriver();

    Waiters waiters = new Waiters(driver);

    Actions actions = new Actions(driver);

    @FindBy(css = "html")
    private WebElement html;

    @FindBy(css = "div.header")
    private WebElement header;

    @FindBy(css = ".mob_fix_container")
    private WebElement posterList;

    @FindBy(css = ".menu-btn")
    private WebElement leftMenuButton;

    @FindBy(css = ".logolink")
    private WebElement logoLink;

    @FindBy(css = ".geo")
    private WebElement geo;

    @FindBy(css = ".geo_select")
    private WebElement rightMenu;

    @FindBy(css = ".lk_link")
    private WebElement signIn;

    @FindBy(css = ".mp_toright")
    private WebElement moveToRight;

    @FindBy(css = ".mp_toleft")
    private WebElement moveToLeft;

    public void getWebPage(String webPage) {
        driver.get(webPage);
    }

    public WebElement getBaseElement(String elementName) {
        WebElement webElement = null;
        switch (elementName) {
            case "HEADER":
                webElement = getHeader();
                break;
            case "POSTER_LIST":
                webElement = getPosterList();
                break;
            case "LEFT_MENU_BUTTON":
                webElement = getLeftMenuButton();
                break;
            case "LOGO":
                webElement = getLogoLink();
                break;
            case "RIGHT_MENU_BUTTON":
                webElement = getRightMenu();
                break;
            case "SIGN_IN":
                webElement = getSignIn();
                break;
            case "GEO":
                webElement = getGeo();
                break;
            case "MOVE_TO_RIGHT":
                webElement = getMoveToRight();
                break;
            case "MOVE_TO_LEFT":
                webElement = getMoveToLeft();
                break;
            default:
                log.error("Unsupported elements type: " + elementName);
        }
        return webElement;
    }

    private Map<String, String> getNavigatedPageCSSLocator() {
        return ImmutableMap.<String, String>builder().put("About Company", ".about_right")
                                                     .put("Help", ".faq-container--page").put("Cinemas", ".map_bg")
                                                     .put("Promotions", ".mp-promo-list").put("Soon", ".soon_body")
                                                     .put("Login", ".login__wrapper").put("Board", ".board-page")
                                                     .build();
    }

    public WebElement findWebElement(By locator) {
        return waiters.waitForElementToBeDisplayed(locator);
    }

    public List<WebElement> findWebElements(By locator) {
        return driver.findElements(locator);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            return Objects.nonNull(webElement.getLocation());
        } catch (NoSuchElementException | NullPointerException | StaleElementReferenceException e) {
            return false;
        }
    }

    public boolean isElementDisplay(By locator) {
        try {
            return findWebElement(locator).isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public boolean isElementDisplay(WebElement webElement) {
        try {
            return waiters.waitForElementToBeDisplayed(webElement).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public boolean isElementActive(WebElement element) {
        try {
            return element.getAttribute("class").contains("active");
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public boolean isElementSelected(WebElement element) {
        try {
            return element.getAttribute("class").contains("is_selected");
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
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

    public void clickOnElement(WebElement element) {
        try {
            waiters.waitForElementToBeClickable(element).click();
        } catch (WebDriverException e) {
            throw new RuntimeException("Element Not Fount On Page: " + e.getMessage());
        }
    }

    public void waitForPageLoad() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void moveToElementAndClick(WebElement element) {
        moveToElement(element);
        waiters.waitForElementToBeClickable(element).click();
    }

    public void moveToElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public void refreshPage() {
        log.info("Refreshing page....");
        driver.navigate().refresh();
    }

    public void verifyNavigatedPage(String page) {
        pageNavigationMenus = getNavigatedPageCSSLocator();
        try {
            if (pageNavigationMenus.containsKey(page)) {
                try {
                    waiters.waitForPresenceOfElement(new By.ByCssSelector(pageNavigationMenus.get(page)));
                } catch (Exception e) {
                    refreshPage();
                    throw new RuntimeException(page + "Not loaded in time. Reattempting by refreshing browser page.");
                }
            }
            waiters.waitForElementToBeDisplayed(new By.ByCssSelector(pageNavigationMenus.get(page)));
        } catch (Exception e) {
            throw new RuntimeException("Page is not defined");
        }
    }
}
