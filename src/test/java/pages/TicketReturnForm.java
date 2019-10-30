package pages;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
@Slf4j
public class TicketReturnForm extends BasePage {

    @FindBy(css = "div.bto.autorefund_form>div.body_form")
    WebElement returnForm;

    @FindBy(css = ".bto.autorefund_form>div.body_form>div.bto_close.rf_cancel")
    WebElement closeButton;

    @FindBy(css = ".bto.autorefund_form>div.body_form>form>div>fieldset>select")
    WebElement selectCinemaButton;

    @FindBy(css = ".bto.autorefund_form>div.body_form>form>div>fieldset.kv>input[name=order]")
    WebElement inputPhone;

    @FindBy(css = ".bto.autorefund_form>div.body_form>form>div>fieldset.kv>input[name=card-first]")
    WebElement inputCardFirst;

    @FindBy(css = ".bto.autorefund_form>div.body_form>form>div>fieldset.kv>input[name=card-last]")
    WebElement inputCardLast;

    @FindBy(css = "fieldset.kv > input.val.autorf_inp.autorf_validate.invalid[name=order]")
    WebElement inputPhoneInvalid;

    @FindBy(css = "fieldset.kv.custom_inps > input.val.autorf_inp.card_first.autorf_validate.invalid")
    WebElement inputCardFirstInvalid;

    @FindBy(css = "fieldset.kv.custom_inps > input.val.autorf_inp.card_last.autorf_validate.invalid")
    WebElement inputCardLastInvalid;

    @FindBy(css = ".mr_text")
    WebElement emergentText;

    @FindBy(css = "div[id=autorf_send]")
    WebElement sendForm;

    @FindBy(css = "div.bto.autorefund_form > div.body_form > div.rf_buttons > div.rf_cancel")
    WebElement cancelButton;

    @FindBy(css = ".idhad")
    WebElement moreOptions;
    
    public WebElement getTicketReturnFormElement(String elementName) {
        WebElement webElement = null;
        switch (elementName) {
            case "TICKET_RETURN":
                webElement = getReturnForm();
                break;
            case "CLOSE_BUTTON":
                webElement = getCloseButton();
                break;
            case "SELECT_CINEMA_BUTTON":
                webElement = getSelectCinemaButton();
                break;
            case "INPUT_PHONE":
                webElement = getInputPhone();
                break;
            case "INPUT_CARD_FIRST":
                webElement = getInputCardFirst();
                break;
            case "INPUT_CARD_LAST":
                webElement = getInputCardLast();
                break;
            case "INPUT_PHONE_INVALID":
                webElement = getInputPhoneInvalid();
                break;
            case "INPUT_CARD_FIRST_INVALID":
                webElement = getInputCardFirstInvalid();
                break;
            case "INPUT_CARD_LAST_INVALID":
                webElement = getInputCardLastInvalid();
                break;
            case "EMERGENT_TEXT":
                webElement = getEmergentText();
                break;
            case "SEND_FORM":
                webElement = getSendForm();
                break;
            case "CANCEL_BUTTON":
                webElement = getCancelButton();
                break;
            case "MORE_OPTIONS":
                webElement = getMoreOptions();
                break;
            default:
                log.error("Unsupported elements type: " + elementName);
        }
        return webElement;
    }
}
