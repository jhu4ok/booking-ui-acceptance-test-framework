package pages;


import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class PromotionsPage extends BasePage {

    @FindBy(css = ".mp-promo-list")
    WebElement promoList;

    By activePromo = new By.ByCssSelector(".promo-item.mp_poster:not(.is-over)");

    By isOverPromo = new By.ByCssSelector(".promo-item.mp_poster.is-over");

    By isOverPromoHolder = new By.ByCssSelector(".promo-item.mp_poster.is-over>.promo-item-holder");

    By isActivePromoHolder = new By.ByCssSelector(".promo-item.mp_poster:not(.is-over)>.promo-item-holder");

    By isOverPromoBottom = new By.ByCssSelector(".promo-item.mp_poster.is-over>.promo-item-bottom");

    By isActivePromoBottom = new By.ByCssSelector(".promo-item.mp_poster:not(.is-over)>.promo-item-bottom");

    public By getPromoPageLocators(String locatorName) {
        By locator = null;
        switch (locatorName) {
            case "PROMO_HOLDER_IS_OVER":
                locator = getIsOverPromoHolder();
                break;
            case "PROMO_BOTTOM_IS_OVER":
                locator = getIsOverPromoBottom();
                break;
            case "PROMO_HOLDER_IS_ACTIVE":
                locator = getIsActivePromoHolder();
                break;
            case "PROMO_BOTTOM_IS_ACTIVE":
                locator = getIsActivePromoBottom();
                break;
            case "ACTIVE_PROMOS":
                locator = getActivePromo();
                break;
            case "IS_OVER_PROMOS":
                locator = getIsOverPromo();
                break;
            default:
                LOG.error("Unsupported elements type: " + locatorName);
        }
        return locator;
    }
}
