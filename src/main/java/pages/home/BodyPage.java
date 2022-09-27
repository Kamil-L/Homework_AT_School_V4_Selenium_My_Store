package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class BodyPage extends BasePage {

    public BodyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".all-product-link")
    private WebElement allProducts;

    public void getAllProducts() {
        click(allProducts);
    }
}
