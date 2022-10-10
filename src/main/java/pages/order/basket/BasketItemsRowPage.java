package pages.order.basket;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasketItemsRowPage {

    public BasketItemsRowPage(WebElement item) {
        PageFactory.initElements(new DefaultElementLocatorFactory(item), this);
    }

    private static final Logger log = LoggerFactory.getLogger(BasketItemsRowPage.class);

    @FindBy(css = ".js-cart-line-product-quantity")
    private WebElement productQuantity;

    @FindBy(css = ".current-price span:first-of-type")
    private WebElement productCurrentPrice;

    @FindBy(css = ".product-price strong")
    private WebElement productTotalPrice;

    @FindBy(css = ".product-line-info a")
    private WebElement productName;


    public String getProductName() {
        return productName.getText();
    }

    public float getProductCurrentPrice() {
        return Float.parseFloat(productCurrentPrice.getText().substring(1));
    }

    public double getProductTotalPrice() {
        return Double.parseDouble(productTotalPrice.getText().substring(1));
    }

    public int getProductQuantity() {
        return Integer.parseInt(productQuantity.getAttribute("value"));
    }
}