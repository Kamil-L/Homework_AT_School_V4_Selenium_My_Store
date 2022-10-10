package pages.order.account;

import models.Address;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.text.MessageFormat;

public class AccountOrderDetailsPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(AccountOrderDetailsPage.class);


    @FindBy(css = "td span.label-pill")
    private WebElement paymentMethodStatus;

    @FindBy(css = "#order-history tr td:nth-child(1)")
    private WebElement orderDate;

    @FindBy(css = "tr.text-xs-right.line-total td:last-of-type")
    private WebElement totalOrderPrice;

    @FindBy(css = "#delivery-address address")
    private WebElement deliveryAddress;

    @FindBy(css = "#invoice-address address")
    private WebElement invoiceAddress;

    public AccountOrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getPaymentMethodStatus() {
        return paymentMethodStatus.getText();
    }

    public String getOrderDate() {
        return orderDate.getText();
    }

    public double getTotalOrderPrice() {
        return Double.parseDouble(totalOrderPrice.getText().substring(1));
    }

    public String getDeliveryAddress() {
        return deliveryAddress.getText();
    }

    public String getInvoiceAddress() {
        return invoiceAddress.getText();
    }

    public String getFormattedAddress(final Address address) {
        final String expectedAddress = "{0} {1}\n{2}\n{3} {4}\n{5}";
        return MessageFormat.format(expectedAddress, address.getFirstName(), address.getLastName(),
                address.getAddress(), address.getZipPostalCode(), address.getCity(), address.getCountry());
    }
}