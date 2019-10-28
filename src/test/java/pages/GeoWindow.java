package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Driver;

@Data
public class GeoWindow extends BasePage {

    @FindBy(css = ".yes")
    private WebElement acceptLocation;

    @FindBy(css = ".geo_balloon.geolocated")
    private WebElement geoWindow;

    @FindBy(css = ".other")
    private WebElement otherLocation;

    @FindBy(css = ".question")
    private WebElement geoQuestion;

    private By currentGeo = new By.ByCssSelector(".geo");

    public void getNewWebPage(String webPage) {
        new Driver().getDriver().get(webPage);
    }
}

