package pages.order.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class CheckoutShippingMethodPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(CheckoutShippingMethodPage.class);

    @FindBy(css = ".carrier-name")
    private WebElement carrierName;

    @FindBy(css = "[name='confirmDeliveryOption']")
    private WebElement shippingContinueBtn;

    public CheckoutShippingMethodPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutShippingMethodPage clickShippingContinueBtn() {
        waitToBeClickable(shippingContinueBtn);
        click(shippingContinueBtn);
        return this;
    }

    public String getCarrierName() {
        return carrierName.getText();
    }
}