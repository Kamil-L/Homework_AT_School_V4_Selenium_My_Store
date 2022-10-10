package pages.order.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class CustomerAccountPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(CustomerAccountPage.class);

    @FindBy(css = "#history-link")
    private WebElement orderHistoryAndDetails;

    public CustomerAccountPage(WebDriver driver) {
        super(driver);
    }

    public CustomerAccountPage goToOrdersHistoryAndDetails() {
        click(orderHistoryAndDetails);
        return this;
    }
}
