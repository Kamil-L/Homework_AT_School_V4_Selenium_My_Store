package pages.order.confirmation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class OrderConfirmationDetailsPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(OrderConfirmationDetailsPage.class);

    @FindBy(css = ".col-md-4 li:nth-child(1)")
    private WebElement orderReference;

    @FindBy(css = ".col-md-4 li:nth-child(2)")
    private WebElement paymentMethod;

    @FindBy(css = ".col-md-4 li:nth-child(3)")
    private WebElement shippingMethod;

    @FindBy(css = "#content-hook_payment_return ul")
    private WebElement checkPaymentDetails;


    public OrderConfirmationDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getOrderReference() {
        waitToBeVisible(orderReference);
        return orderReference.getText().replaceAll(".*: ", "");
    }

    public String getPaymentMethod() {
        waitToBeVisible(paymentMethod);
        return paymentMethod.getText().replaceAll(".*: ", "");
    }

    public String getShippingMethod() {
        waitToBeVisible(shippingMethod);
        return shippingMethod.getText().replaceAll(".*: ", "");
    }

    public String getCheckPaymentDetails() {
        return checkPaymentDetails.getText();
    }
}