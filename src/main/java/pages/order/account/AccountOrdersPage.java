package pages.order.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class AccountOrdersPage extends BasePage {

    @FindBy(css = "tbody tr")
    private List<WebElement> allOrdersReferences;

    @FindBy(xpath = "//a[contains(text(),'Details')]")
    private WebElement orderDetails;

    public AccountOrdersPage(WebDriver driver) {
        super(driver);
    }

    public void goToOrderDetails(AccountOrderRowPage orderReference) {
        Actions actions = new Actions(driver);
        actions.moveToElement(orderDetails)
                .click(orderDetails)
                .perform();
    }

    public List<AccountOrderRowPage> getAllOrdersReferences() {
        List<AccountOrderRowPage> allOrdersReferences = new ArrayList<>();
        for (WebElement orderReference : this.allOrdersReferences) {
            allOrdersReferences.add(new AccountOrderRowPage(orderReference));
        }
        return allOrdersReferences;
    }

    public AccountOrdersPage goToOrderDetailsByOrderId(String orderID) {
        for (AccountOrderRowPage orderReference : getAllOrdersReferences()) {
            if ((orderReference.getOrderReference().contains(orderID.toUpperCase()))) {
                goToOrderDetails(orderReference);
                break;
            }
        }
        return this;
    }
}