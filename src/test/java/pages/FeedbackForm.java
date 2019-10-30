package pages;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
@Slf4j
public class FeedbackForm extends BasePage {

    @FindBy(css = "#feedback > div > div.support_option.support.ct_frm_spt")
    WebElement supportFeedbackForm;

    @FindBy(css = "body > div.bto.contact_form_support > div.body_form > form")
    WebElement supportForm;

    @FindBy(css = "div.bto.contact_form_support >div.body_form >.heading")
    WebElement heading;

    @FindBy(css = "#contact_form_support_name")
    WebElement nameInput;

    @FindBy(css = "#contact_form_support_email")
    WebElement emailInput;

    @FindBy(css = ".email_inp.val.err")
    WebElement emailInputInvalid;

    @FindBy(css = "#contact_form_support_phone")
    WebElement phoneInput;

    @FindBy(css = ".val.autorf_validate.autorf_inp.form_phone.err")
    WebElement phoneInputInvalid;

    @FindBy(css = "#contact_form_support_type")
    WebElement enquireType;

    @FindBy(css = "#contact_form_support_message")
    WebElement messageInput;

    @FindBy(css = "#contact_form_support_message[class=\"val err\"]")
    WebElement messageInputInvalid;

    @FindBy(css = "div.bto.contact_form_support >div.body_form >form >div.rf_buttons >div.about-submit")
    WebElement submitButton;

    @FindBy(css = "body >div.bto.contact_form_support >div.body_form >.bto_close.rf_cancel")
    WebElement cancelButton;

    public WebElement getFeedbackFormElement(String elementName) {
        WebElement webElement = null;
        switch (elementName) {
            case "SUPPORT":
                webElement = getSupportForm();
                break;
            case "SUPPORT_FEEDBACK":
                webElement = getSupportFeedbackForm();
                break;
            case "NAME_INPUT":
                webElement = getNameInput();
                break;
            case "HEADING":
                webElement = getHeading();
                break;
            case "EMAIL_INPUT":
                webElement = getEmailInput();
                break;
            case "EMAIL_INPUT_INVALID":
                webElement = getEmailInputInvalid();
                break;
            case "PHONE_INPUT":
                webElement = getPhoneInput();
                break;
            case "PHONE_INPUT_INVALID":
                webElement = getPhoneInputInvalid();
                break;
            case "ENQUIRE_TYPE_INPUT":
                webElement = getEnquireType();
                break;
            case "MESSAGE_INPUT":
                webElement = getMessageInput();
                break;
            case "MESSAGE_INPUT_INVALID":
                webElement = getMessageInputInvalid();
                break;
            case "SUBMIT_BUTTON":
                webElement = getSubmitButton();
                break;
            case "CANCEL_BUTTON":
                webElement = getCancelButton();
                break;
            default:
                log.error("Unsupported elements type: " + elementName);
        }
        return webElement;
    }
}
