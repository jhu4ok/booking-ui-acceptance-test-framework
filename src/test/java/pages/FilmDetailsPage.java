package pages;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
@Slf4j
public class FilmDetailsPage extends BasePage {

    @FindBy(css = ".ct_holder")
    WebElement poster;

    @FindBy(css = "#mvi_title")
    WebElement filmTitle;

    @FindBy(css = ".rating>.val")
    WebElement filmRating;

    @FindBy(css = ".movie_credentials")
    WebElement movieCredentials;

    @FindBy(css = ".movie_description")
    WebElement movieDescription;

    @FindBy(css = "#desktop_trailer")
    WebElement trailerButton;

    @FindBy(css = ".modal_youtube")
    WebElement video;

    @FindBy(css = "#desktop_review")
    WebElement reviewButton;

    @FindBy(css = ".age_hint")
    WebElement yearHint;

    @FindBy(css = "#fv2_datesel")
    WebElement selectDate;

    @FindBy(css = "li[data-dayname=\"Завтра\"]")
    WebElement nextDay;

    @FindBy(css = ".selector")
    WebElement selector;

    @FindBy(css = " div.all_sessions_area.is-scrollable > div:nth-child(3) > div:nth-child(1) > div:nth-child(2)")
    WebElement sessionTime;

    By dayName = new By.ByCssSelector(".smartdayname");

    By dayDate = new By.ByCssSelector(".smartdaydets");

    By left = new By.ByCssSelector(".left");

    By right = new By.ByCssSelector(".right");

    public WebElement getFilmPageElement(String elementName) {
        WebElement webElement = null;
        switch (elementName) {
            case "TRAILER_BUTTON":
                webElement = getTrailerButton();
                break;
            case "VIDEO":
                webElement = getVideo();
                break;
            case "REVIEW_BUTTON":
                webElement = getReviewButton();
                break;
            case "YEAR_HINT":
                webElement = getYearHint();
                break;
            case "POSTER":
                webElement = getPoster();
                break;
            case "FILM_TITLE":
                webElement = getFilmTitle();
                break;
            case "YEAR_RATING":
                webElement = getFilmRating();
                break;
            case "FILM_CREDENTIALS":
                webElement = getMovieCredentials();
                break;
            case "FILM_DESCRIPTION":
                webElement = getMovieDescription();
                break;
            case "SELECT_DATE":
                webElement = getSelectDate();
                break;
            case "NEXT_DAY":
                webElement = getNextDay();
                break;
            case "SESSION_TIME":
                webElement = getSessionTime();
                break;
            default:
                log.error("Unsupported elements type: " + elementName);
        }
        return webElement;
    }
}
