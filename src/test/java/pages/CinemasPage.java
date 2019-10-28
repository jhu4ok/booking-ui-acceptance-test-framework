package pages;


import com.google.common.collect.ImmutableMap;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

@Data
public class CinemasPage extends BasePage {

    @FindBy(css = "div.cl_cinemas > div:nth-child(1) > div.meta > div > p.top > a > span")
    WebElement firstCinema;

    @FindBy(css = ".cimenas_filters")
    WebElement cinemasFilter;

    @FindBy(css = ".fancy_select")
    WebElement citiesDropDown;

    @FindBy(css = "a[href=\"/ua/cinemas/dnipro\"]")
    WebElement dropDownCity;

    @FindBy(css = "div[data-flt=\"data-serv6\"")
    WebElement easyPass;

    @FindBy(css = "div[data-flt=\"data-serv7\"")
    WebElement vip;

    @FindBy(css = "div[data-flt=\"data-serv8\"")
    WebElement lux;

    @FindBy(css = "div[data-flt=\"data-serv9\"")
    WebElement disabled;

    @FindBy(css = "div[data-flt=\"data-serv15\"")
    WebElement turnstile;

    @FindBy(css = "div[data-flt=\"data-serv21\"")
    WebElement chillOut;

    @FindBy(css = "div[data-flt=\"data-serv4\"")
    WebElement football;

    @FindBy(css = "div[data-flt=\"data-serv3\"")
    WebElement theatre;

    @FindBy(css = "div[data-flt=\"data-serv5\"")
    WebElement originalVoice;

    @FindBy(css = "div[data-flt=\"data-serv10\"")
    WebElement mCafe;

    @FindBy(css = "div[data-flt=\"data-serv13\"")
    WebElement hallRent;

    @FindBy(css = "div[data-flt=\"data-serv12\"")
    WebElement hallOrder;

    @FindBy(css = "div[data-flt=\"data-serv16\"")
    WebElement photo;

    @FindBy(css = "div[data-flt=\"data-serv17\"")
    WebElement games;

    @FindBy(css = "div[data-flt=\"data-serv19\"")
    WebElement mClub;

    @FindBy(css = "div[data-flt=\"data-serv22\"")
    WebElement kidsRoom;

    @FindBy(css = "div[data-flt=\"data-serv2\"")
    WebElement twins;

    @FindBy(css = "div[data-flt=\"data-serv14\"")
    WebElement imax;

    @FindBy(css = "div[data-flt=\"data-serv18\"")
    WebElement laser;

    @FindBy(css = "div[data-flt=\"data-serv20\"")
    WebElement screenx;

    @FindBy(css = "body > div.mob_fix_container > div.cl_cinemas > div:nth-child(2) > a")
    WebElement cinemaPosterButton;

    @FindBy(css = "body > div.mob_fix_container > div.cl_cinemas > div:nth-child(2) > div.meta > a")
    WebElement cinemaScheduleButton;

    @FindBy(css = ".map_top")
    WebElement mapTop;

    @FindBy(css = ".map_container")
    WebElement map;

    By filterAreas = new By.ByCssSelector(".filter_area");

    By cinema = new By.ByCssSelector(".cl_cinema");

    By cityName = new By.ByCssSelector(".cityname");

    By cinemaPoster = new By.ByCssSelector(".pic");

    By cinemaName = new By.ByCssSelector(".name");

    By cinemaAddress = new By.ByCssSelector(".address");

    By cinemaSchedule = new By.ByCssSelector(".sch_but");

    By cinemaFeatures = new By.ByCssSelector(".features");

    String cityOnMap = "div[data-cityurl=%s]";

    public WebElement getCinemasPageElement(String elementName) {
        WebElement webElement = null;
        switch (elementName) {
            case "MAP":
                webElement = getMap();
                break;
            case "MAP_TOP":
                webElement = getMapTop();
                break;
            case "CINEMA_POSTER_BUTTON":
                webElement = getCinemaPosterButton();
                break;
            case "CINEMA_SCHEDULE_BUTTON":
                webElement = getCinemaScheduleButton();
                break;
            case "FIRST_CINEMA":
                webElement = getFirstCinema();
                break;
            case "CINEMAS_FILTER":
                webElement = getCinemasFilter();
                break;
            case "CITIES_DROP_DOWN":
                webElement = getCitiesDropDown();
                break;
            case "DROP_DOWN_CITY":
                webElement = getDropDownCity();
                break;
            case "EASY PASS":
                webElement = getEasyPass();
                break;
            case "VIP":
                webElement = getVip();
                break;
            case "LUX":
                webElement = getLux();
                break;
            case "DISABLED":
                webElement = getDisabled();
                break;
            case "TURNSTILE":
                webElement = getTurnstile();
                break;
            case "CHILL OUT":
                webElement = getChillOut();
                break;
            case "FOOTBALL":
                webElement = getFootball();
                break;
            case "THEATRE":
                webElement = getTheatre();
                break;
            case "ORIGINAL VOICE":
                webElement = getOriginalVoice();
                break;
            case "M CAFE":
                webElement = getMCafe();
                break;
            case "HALL ORDER":
                webElement = getHallOrder();
                break;
            case "HALL RENT":
                webElement = getHallRent();
                break;
            case "PHOTO":
                webElement = getPhoto();
                break;
            case "GAMES":
                webElement = getGames();
                break;
            case "M CLUB":
                webElement = getMClub();
                break;
            case "KIDS ROOM":
                webElement = getKidsRoom();
                break;
            case "TWINS":
                webElement = getTwins();
                break;
            case "IMAX":
                webElement = getImax();
                break;
            case "LASER":
                webElement = getLaser();
                break;
            case "SCREENX":
                webElement = getScreenx();
                break;
            default:
                LOG.error("Unsupported elements type: " + elementName);
        }
        return webElement;
    }

    public By getCinemasPageLocator(String locatorName) {
        By locator = null;
        switch (locatorName) {
            case "FILTER_AREA":
                locator = getFilterAreas();
                break;
            case "CINEMA_POSTER":
                locator = getCinemaPoster();
                break;
            case "CITY_NAME":
                locator = getCityName();
                break;
            case "CINEMA_NAME":
                locator = getCinemaName();
                break;
            case "CINEMA_ADDRESS":
                locator = getCinemaAddress();
                break;
            case "CINEMA_SCHEDULE":
                locator = getCinemaSchedule();
                break;
            case "CINEMA_FEATURES":
                locator = getCinemaFeatures();
                break;

            default:
                LOG.error("Unsupported elements type: " + locatorName);
        }
        return locator;
    }

    public boolean isElementChecked(WebElement element) {
        try {
            return element.getAttribute("class").contains("checked");
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public String getCinemaAttribute(String attributeName) {
        Map<String, String> attributeMap =
            ImmutableMap.<String, String>builder().put("EASY PASS", "data-serv6").put("VIP", "data-serv7")
                                                  .put("LUX", "data-serv8").put("DISABLED", "data-serv9")
                                                  .put("TURNSTILE", "data-serv15").put("CHILL OUT", "data-serv21")
                                                  .put("FOOTBALL", "data-serv4").put("THEATRE", "data-serv3")
                                                  .put("ORIGINAL VOICE", "data-serv5").put("M CAFE", "data-serv10")
                                                  .put("HALL ORDER", "data-serv12").put("HALL RENT", "data-serv13")
                                                  .put("PHOTO", "data-serv16").put("GAMES", "data-serv17")
                                                  .put("M CLUB", "data-serv19").put("KIDS ROOM", "data-serv22")
                                                  .put("TWINS", "data-serv2").put("IMAX", "data-serv14")
                                                  .put("SCREENX", "data-serv20").put("LASER", "data-serv18")

                                                  .build();
        return attributeMap.get(attributeName);
    }
}
