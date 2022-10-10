package pages.order.basket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class BasketSummaryPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(BasketSummaryPage.class);

    @FindBy(css = "#cart-subtotal-products .value")
    private WebElement totalItemsPrice;

    @FindBy(css = ".checkout .btn")
    private WebElement proceedToCheckoutBtn;


    public BasketSummaryPage(WebDriver driver) {
        super(driver);
    }

    public BasketSummaryPage clickProceedToCheckoutBtn () {
        click(proceedToCheckoutBtn);
        return this;
    }

    public double getTotalItemsPrice() {
        return Double.parseDouble(totalItemsPrice.getText().substring(1));
    }
}
