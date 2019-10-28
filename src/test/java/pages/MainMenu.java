package pages;


import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class MainMenu extends BasePage {
    @FindBy(css = ".menu-btn")
    WebElement mainMenuButton;

    @FindBy(css = ".container")
    WebElement mainMenu;

    @FindBy(css = ".container")
    WebElement mainMenuContainer;

    @FindBy(css = "div.menu_close")
    WebElement menuClose;

    @FindBy(css = ".menu_logo")
    WebElement menuLogo;

    @FindBy(css = ".langs")
    WebElement menuLangs;

    @FindBy(xpath = "//div/a[@href='/ua/about']")
    WebElement menuAboutCompany;

    @FindBy(xpath = "//div/a[@href='/ua/faq']")
    WebElement menuHelp;

    @FindBy(xpath = "//div/a[@href='/ua/promotions']")
    WebElement menuPromotions;

    @FindBy(xpath = "//div/a[@href='/ua/soon']")
    WebElement menuSoon;

    @FindBy(xpath = "//div/a[@href='/ua/cinemas']")
    WebElement menuCinemas;

    @FindBy(css = ".menu-block-btn")
    WebElement menuLogin;

    @FindBy(css = ".menu-block-phone")
    WebElement menuPhone;

    @FindBy(css = ".menu_soc")
    WebElement socialMedia;

    @FindBy(css = "li[data-lang=\"ru\"]")
    WebElement ru;

    @FindBy(css = "li[data-lang=\"ua\"]")
    WebElement ua;

    public WebElement getMainMenuElement(String elementName) {
        WebElement webElement = null;
        switch (elementName) {
            case "RU":
                webElement = getRu();
                break;
            case "UA":
                webElement = getUa();
                break;
                case "MENU_CONTAINER":
                webElement = getMainMenuContainer();
                break;
            case "LEFT_MENU":
                webElement = getMainMenu();
                break;
            case "CLOSE_BUTTON":
                webElement = getMenuClose();
                break;
            case "MENU_LOGO":
                webElement = getMenuLogo();
                break;
            case "LANGUAGE_OPTIONS":
                webElement = getMenuLangs();
                break;
            case "MAIN_MENU_BUTTON":
                webElement = getMainMenuButton();
                break;
            case "ABOUT_COMPANY":
                webElement = getMenuAboutCompany();
                break;
            case "SOON":
                webElement = getMenuSoon();
                break;
            case "HELP":
                webElement = getMenuHelp();
                break;
            case "CINEMAS":
                webElement = getMenuCinemas();
                break;
            case "PROMOTIONS":
                webElement = getMenuPromotions();
                break;
            case "LOGIN":
                webElement = getMenuLogin();
                break;
            case "PHONE":
                webElement = getMenuPhone();
                break;
            case "SOCIAL_MEDIA":
                webElement = getSocialMedia();
                break;
            default:
                LOG.error("Unsupported elements type: " + elementName);
        }
        return webElement;
    }
}
