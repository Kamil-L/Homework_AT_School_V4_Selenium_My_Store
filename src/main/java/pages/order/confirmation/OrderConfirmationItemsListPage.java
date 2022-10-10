package pages.order.confirmation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class OrderConfirmationItemsListPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(OrderConfirmationItemsListPage.class);

    @FindBy(css = ".details span")
    private WebElement itemName;

    @FindBy(css = ".qty .row div:nth-child(1)")
    private WebElement unitPrice;

    @FindBy(css = ".qty .row div:nth-child(2)")
    private WebElement quantity;

    @FindBy(css = ".qty .row div:nth-child(3)")
    private WebElement totalProductPrice;

    @FindBy(xpath = "//tbody/tr[2]/td[2]")
    private WebElement shippingCost;

    public OrderConfirmationItemsListPage(WebDriver driver) {
        super(driver);
    }

    public String getItemName() {
        return itemName.getText().replaceAll(" - .*", "");
    }

    public double getUnitPrice() {
        return Double.parseDouble(unitPrice.getText().substring(1));
    }

    public int getQuantity() {
        return Integer.parseInt(quantity.getText());
    }

    public double getTotalProductPrice() {
        return Double.parseDouble(totalProductPrice.getText().substring(1));
    }

    public String getShippingCost() {
        return shippingCost.getText();
    }
}