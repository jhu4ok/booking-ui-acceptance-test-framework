package pages;


import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class SoonPage extends BasePage {

    @FindBy(css = ".soon_top")
    WebElement soonTop;

    @FindBy(css = ".may_not")
    WebElement mayNot;

    @FindBy(css = ".show_hint")
    WebElement showHint;

    @FindBy(css = ".may_not_hint")
    WebElement mayNotHint;

    @FindBy(css = ".mvi_nav")
    WebElement filmNavigator;

    @FindBy(css = ".soon_by_day")
    WebElement soonByDay;

    @FindBy(css = "div.soon_wrapper > ul > li:nth-child(2) > a")
    WebElement filmsByDay;

    @FindBy(css = "div.soon_wrapper > ul > li:nth-child(3) > a")
    WebElement theatreByDay;

    @FindBy(css = "div.soon_wrapper > ul > li:nth-child(1) > a")
    WebElement allByDay;

    @FindBy(css = "div:nth-child(1) > div.el_left.clearfix > p.el_day_date")
    WebElement posterDate;

    @FindBy(css = "div.soon_by_day > div:nth-child(1) > div.el_right")
    WebElement posterBlock;

    @FindBy(css = "a:nth-child(1) > div > div.on_sale")
    WebElement onSaleButton;

    @FindBy(css = "div.soon_el.scrolling > div.el_right > a:nth-child(1) > div > div.soon_fm_poster")
    WebElement poster;

    @FindBy(css = "div:nth-child(1) > div.el_right > a:nth-child(1) > span.soon_fm_name")
    WebElement posterName;

    public WebElement getSoonPageElement(String elementName) {
        WebElement webElement = null;
        switch (elementName) {
            case "SOON_TOP":
                webElement = getSoonTop();
                break;
            case "MAY_NOT":
                webElement = getMayNot();
                break;
            case "SHOW_HINT":
                webElement = getShowHint();
                break;
            case "MAY_NOT_HINT":
                webElement = getMayNotHint();
                break;
            case "FILM_NAVIGATOR":
                webElement = getFilmNavigator();
                break;
            case "SOON_BY_DAY":
                webElement = getSoonByDay();
                break;
            case "FILM_BY_DAY":
                webElement = getFilmsByDay();
                break;
            case "THEATRE_BY_DAY":
                webElement = getTheatreByDay();
                break;
            case "ALL_BY_DAY":
                webElement = getAllByDay();
                break;
            case "POSTER_DATE":
                webElement = getPosterDate();
                break;
            case "POSTER_BLOCK":
                webElement = getPosterBlock();
                break;
            case "ON_SALE":
                webElement = getOnSaleButton();
                break;
            case "POSTER":
                webElement = getPoster();
                break;
            case "POSTER_NAME":
                webElement = getPosterName();
                break;
            default:
                LOG.error("Unsupported elements type: " + elementName);
        }
        return webElement;
    }
}
