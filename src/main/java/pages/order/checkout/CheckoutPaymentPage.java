package pages.order.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class CheckoutPaymentPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(CheckoutPaymentPage.class);

    @FindBy(css = "#payment-option-1")
    private WebElement payByCheckRadioBtn;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement termsOfServiceCheckout;

    @FindBy(css = ".btn.center-block")
    private WebElement placeOrderBtn;

    public CheckoutPaymentPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPaymentPage selectPayByCheckRadioBtn() {
        actions.moveToElement(payByCheckRadioBtn)
                .click(payByCheckRadioBtn)
                .perform();
        return this;
    }

    public CheckoutPaymentPage acceptTermsOfService() {
        actions.moveToElement(termsOfServiceCheckout)
                .click(termsOfServiceCheckout)
                .perform();
        return this;
    }

    public CheckoutPaymentPage clickPlaceOrderBtn() {
        click(placeOrderBtn);
        return this;
    }
}