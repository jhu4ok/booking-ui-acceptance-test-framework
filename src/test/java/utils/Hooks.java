package utils;

import io.cucumber.core.api.Scenario;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {
    private static final Logger LOG = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void beforeScenario(Scenario scenario) {
        LOG.info("###### Starting Test Scenario : {} ######", scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {

        LOG.info("###### Finished Test Scenario : {} ######",
                 scenario.getName() + " -> Status: " + scenario.getStatus());

        if (scenario.isFailed()) {
            embedScreenshot(scenario);
        }
    }

    private void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenShot = ((TakesScreenshot) Driver.driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenShot, "image/png");
            } catch (WebDriverException e) {
                LOG.error(e.getMessage());
            }
        }
    }

}
