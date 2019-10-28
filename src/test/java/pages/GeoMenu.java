package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class GeoMenu extends BasePage {

    @FindBy(css = ".geo_select")
    private WebElement geoSelect;

    @FindBy(css = ".menu.right_menu.animatedlong.slideInUp")
    private WebElement geoMenu;

    @FindBy(css = ".citylist")
    private WebElement cityList;

    @FindBy(css = ".rm_clist")
    private WebElement cinemaList;

    @FindBy(css = "img.menu_close")
    private WebElement closeButton;

    public WebElement getGeoMenuElement(String elementName) {
        WebElement webElement = null;
        switch (elementName) {
            case "GEO_MENU":
                webElement = getGeoMenu();
                break;
            case "GEO_SELECT":
                webElement = getGeoSelect();
                break;
            case "CITY_LIST":
                webElement = getCityList();
                break;
            case "CLOSE_BUTTON":
                webElement = getCloseButton();
                break;
            case "CINEMA_LIST":
                webElement = getCinemaList();
                break;
            default:
                LOG.error("Unsupported elements type: " + elementName);
        }
        return webElement;
    }
}