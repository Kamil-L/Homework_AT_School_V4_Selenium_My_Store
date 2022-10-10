package pages.order.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class CheckoutAddressesPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(CheckoutAddressesPage.class);

    @FindBy(css = "[data-link-action='different-invoice-address']")
    private WebElement addDifferentInvoiceAddress;

    @FindBy(xpath = "//a[@href='http://146.59.32.4/index.php?controller=order&newAddress=invoice']")
    private WebElement addNewAddressInvoice;


    public CheckoutAddressesPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutAddressesPage clickAddDifferentInvoiceAddressBtn() {
        click(addDifferentInvoiceAddress);
        return this;
    }

    public CheckoutAddressesPage clickAddNewInvoiceAddressBtn() {
        actions.moveToElement(addNewAddressInvoice)
                .click(addNewAddressInvoice)
                .perform();
        return this;
    }
}
