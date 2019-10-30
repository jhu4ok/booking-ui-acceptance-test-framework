package pages;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
@Slf4j
public class CinemaPage extends BasePage {

    @FindBy(css = "div.mob_fix_container.mob_fix_container-cinema")
    WebElement cinemaPage;

    @FindBy(css = "div.cinema_inside > h1[itemprop=name]")
    WebElement cinemaName;

    @FindBy(css = "p[itemprop=streetAddress]")
    WebElement streetAddress;

    @FindBy(css = "p[itemprop=addressLocality]")
    WebElement addressLocality;

    @FindBy(css = "a>span[itemprop=telephone]")
    WebElement telephone;

    @FindBy(css = ".cinema_schedule_filters")
    WebElement cinemaScheduleFilter;

    @FindBy(css = ".cinema_schedule_header")
    WebElement cinemaScheduleHeader;

    @FindBy(css = ".cinema_schedule_films")
    WebElement cinemaScheduleFilmList;

    @FindBy(css = ".filter_body.format")
    WebElement cinemaFormats;

    @FindBy(css = ".filter_body.hall")
    WebElement cinemaHalls;

    @FindBy(css = ".cinema_pics")
    WebElement cinemaPics;

    @FindBy(css = ".rules")
    WebElement rules;

    @FindBy(css = "div.ns.locked > p.time")
    WebElement time;

    @FindBy(css = "div:nth-child(1) > div > div > div.ns.locked > span.price_min_max")
    WebElement price;

    @FindBy(css = "div.cinema_schedule_films > div > div:nth-child(2) > div:nth-child(1) > div.info")
    WebElement info;

    @FindBy(css = "div:nth-child(2) > div:nth-child(1) > a > div.poster.is-desktop")
    WebElement poster;

    @FindBy(css = "div.cinema_schedule_films > div > div:nth-child(2) > div:nth-child(1) > div > a")
    WebElement filmName;

    @FindBy(css = "div.cinema_schedule_header > div > div > a:nth-child(2)")
    WebElement nextDay;

    @FindBy(css = "ul.filter_list.list_format>li[data-format=\"2D\"]")
    WebElement twoD;

    @FindBy(css = "ul.filter_list.list_format>li[data-format=\"3D\"]")
    WebElement threeD;

    @FindBy(css = "ul.filter_list.list_format>li[data-format=\"IMAX L 3D\"]")
    WebElement iMaxThreeD;

    @FindBy(css = "ul.filter_list.list_format>li[data-format=\"IMAX L 2D\"]")
    WebElement iMaxTwoD;

    @FindBy(css = "ul.filter_list.list_format>li[data-format=\"KIDS\"]")
    WebElement kids;

    @FindBy(css = "ul.filter_list.list_hall>li[data-format=\"usual\"]")
    WebElement usual;

    @FindBy(css = "ul.filter_list.list_hall>li[data-format=\"LUX\"]")
    WebElement lux;

    By cinemaFilterHint = new By.ByCssSelector(".filter_hint");

    By activeFilms = new By.ByCssSelector(".cinema_inside.sch_date:not(.hidden)>.film");

    By activeFilmsTitle = new By.ByCssSelector(".cinema_inside.sch_date:not(.hidden)>div>a");

    By activeFilmsSessions = new By.ByCssSelector(".cinema_inside.sch_date:not(.hidden)>.film>.info>.sessions");

    By activeFilmsSessionsTime = new By.ByCssSelector(".cinema_inside.sch_date:not(.hidden)>.film>.info>.sessions>.ns");

    By scheduleDate = new By.ByCssSelector("a.date");

    By scheduleDay = new By.ByCssSelector("a.date>.dateval");

    By scheduleDayName = new By.ByCssSelector("a.date>.datedesc");

    public By getCinemaPageLocator(String locatorName) {
        By locator = null;
        switch (locatorName) {
            case "ACTIVE_FILMS":
                locator = getActiveFilms();
                break;
            case "ACTIVE_FILMS_TITLE":
                locator = getActiveFilmsTitle();
                break;
            case "ACTIVE_FILMS_SESSIONS":
                locator = getActiveFilmsSessions();
                break;
            case "ACTIVE_FILMS_SESSIONS_TIME":
                locator = getActiveFilmsSessionsTime();
                break;
            case "SCHEDULE_DATE":
                locator = getScheduleDate();
                break;
            case "SCHEDULE_DAY":
                locator = getScheduleDay();
                break;
            case "SCHEDULE_DAY_NAME":
                locator = getScheduleDayName();
                break;
            case "FILTER_HINT":
                locator = getCinemaFilterHint();
                break;
            default:
                log.error("Unsupported elements type: " + locatorName);
        }
        return locator;
    }

    public WebElement getCinemaPageElement(String elementName) {
        WebElement webElement = null;
        switch (elementName) {
            case "CINEMA_PAGE":
                webElement = getCinemaPage();
                break;
            case "HALL":
                webElement = getCinemaHalls();
                break;
            case "FORMATS":
                webElement = getCinemaFormats();
                break;
            case "CINEMA_NAME":
                webElement = getCinemaName();
                break;
            case "STREET_ADDRESS":
                webElement = getStreetAddress();
                break;
            case "ADDRESS_LOCALITY":
                webElement = getAddressLocality();
                break;
            case "TELEPHONE":
                webElement = getTelephone();
                break;
            case "SCHEDULE_FILTER":
                webElement = getCinemaScheduleFilter();
                break;
            case "SCHEDULE_HEADER":
                webElement = getCinemaScheduleHeader();
                break;
            case "SCHEDULE_FILM":
                webElement = getCinemaScheduleFilmList();
                break;
            case "CINEMA_PICS":
                webElement = getCinemaPics();
                break;
            case "CINEMA_RULES":
                webElement = getRules();
                break;
            case "TIME":
                webElement = getTime();
                break;
            case "INFO":
                webElement = getInfo();
                break;
            case "PRICE":
                webElement = getPrice();
                break;
            case "POSTER":
                webElement = getPoster();
                break;
            case "FILM_NAME":
                webElement = getFilmName();
                break;
            case "NEXT_DAY":
                webElement = getNextDay();
                break;
            case "2D":
                webElement = getTwoD();
                break;
            case "IMAX L 2D":
                webElement = getIMaxTwoD();
                break;
            case "IMAX L 3D":
                webElement = getIMaxThreeD();
                break;
            case "3D":
                webElement = getThreeD();
                break;
            case "KIDS":
                webElement = getKids();
                break;
            case "USUAL":
                webElement = getUsual();
                break;
            case "LUX":
                webElement = getLux();
                break;

            default:
                log.error("Unsupported elements type: " + elementName);
        }
        return webElement;
    }
}
