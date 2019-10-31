package utils;

import io.cucumber.core.api.Scenario;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

@Slf4j
public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        log.info("###### Starting Test Scenario : {} ######", scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {

        log.info("###### Finished Test Scenario : {} ######",
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
                log.error(e.getMessage());
            }
        }
    }

}
