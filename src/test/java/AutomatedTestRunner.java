import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, strict = true,
    features = "src\\test\\resources",
    tags = "@Regression", junit = "--step-notifications", plugin = {
    "html:target/cucumber", "json:target/cucumber.json", "rerun:target/rerun/failed_scenarios.txt", "pretty",}, glue = {
    "stepdefinitions", "enums", "pages", "setup", "utils", "utils.Hooks"})
public class AutomatedTestRunner {
}
