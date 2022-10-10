package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import pages.products.ProductPopupCartPage;

import java.util.List;

public class HomePage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(HomePage.class);

    @FindBy(css = ".all-product-link")
    private WebElement allProductsLink;

    @FindBy(css = "#index")
    private List<WebElement> bodyHomePage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickAllProductsLink() {
        click(allProductsLink);
        return this;
    }

    public HomePage goToHomePage () {
        driver.get("http://146.59.32.4/index.php");
        waitForVisibilityOfAllElements(bodyHomePage);
        return this;
    }
}
