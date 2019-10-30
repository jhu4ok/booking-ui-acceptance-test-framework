package pages;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
@Slf4j
public class HomePage extends BasePage {
    @FindBy(xpath = "//div[@class=\"mp_poster \"][1]")
    WebElement firstPoster;

    @FindBy(xpath = "//div[@class=\"mp_poster \"][1]/a")
    WebElement posterTitle;

    @FindBy(css = "#mp_postersList > div:nth-child(2) > div.mpp_mask.animated.fadeIn > div.toplinks > a.mpp_tomoviepage")
    WebElement filmDetailsButton;

    private By acceptGeoWindow = new By.ByCssSelector(".geo_veil.geolocated.desktop-only");

    private String cityCinemasSelector = "//div[contains(@data-cityname,'%s')]";

    private String cinemasSelector = "//p[@class='cname_s cname']/span";

    public WebElement getHomePageElement(String elementName) {
        WebElement webElement = null;
        switch (elementName) {
            case "FIRST_POSTER":
                webElement = getFirstPoster();
                break;
            case "POSTER_LIST":
                webElement = getPosterList();
                break;
            case "POSTER_TITLE":
                webElement = getPosterTitle();
                break;
            case "FILM_DETAILS_BUTTON":
                webElement = getFilmDetailsButton();
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
}
