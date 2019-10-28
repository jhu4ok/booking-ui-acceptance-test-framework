package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Waiters {
    private static final Logger LOG = LoggerFactory.getLogger(Waiters.class);

    private WebDriver driver;

    private WebDriverWait wait;

    public Waiters(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 15);
    }

    public WebElement waitForPresenceOfElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForElementToBeDisplayed(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeDisplayed(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public Boolean waitForElementToDisappear(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}


