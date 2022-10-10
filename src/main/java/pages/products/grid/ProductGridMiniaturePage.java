package pages.products.grid;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductGridMiniaturePage {

    private static final Logger log = LoggerFactory.getLogger(ProductGridMiniaturePage.class);

    public ProductGridMiniaturePage(WebElement productMiniature) {
        PageFactory.initElements(new DefaultElementLocatorFactory(productMiniature), this);
    }

    @FindBy(css = ".product-title")
    private WebElement productName;

    @FindBy(css = ".price")
    private WebElement productCurrentPrice;

    @FindBy(css = ".regular-price")
    private WebElement productRegularPrice;

    @FindBy(css = ".quick-view")
    private WebElement productQuickViewButton;

    @FindBy(css = ".product-flags .discount")
    private WebElement productDiscountFlagValue;


    public String getProductName() {
        return productName.getText();
    }

    public String getProductCurrentPrice() {
        return productCurrentPrice.getText().replaceAll("\\$|\\.00", "");
    }

    public String getProductRegularPrice() {
        return productRegularPrice.getText();
    }

    public String getProductQuickViewButton() {
        return productQuickViewButton.getText();
    }

    public String getProductDiscountFlagValue() {
        return productDiscountFlagValue.getText();
    }
}