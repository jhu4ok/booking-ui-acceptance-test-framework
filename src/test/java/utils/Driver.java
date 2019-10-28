package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Driver {

    private static final Logger LOG = LoggerFactory.getLogger(Driver.class);

    public static WebDriver driver = getChromeDriver();

    public WebDriver getDriver() {

        return driver;
    }

    public static WebDriver getChromeDriver() {
        LOG.info("Initialize Chrome Driver:");
        return new ChromeDriver(getChromeOptions());
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-default-browser-check");
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-logging");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-web-security");
        options.addArguments("--headless");
        options.addArguments("--window-size=1552,840");
        return options;
    }
}


