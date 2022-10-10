package pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class ProductPopupCartPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(ProductPopupCartPage.class);

    @FindBy(css = ".product-name")
    private WebElement productName;

    @FindBy(css = ".product-price")
    private WebElement productPrice;

    @FindBy(css = ".product-quantity strong")
    private WebElement productQuantity;

    @FindBy(css = ".cart-content .cart-products-count")
    private WebElement cartTotalCount;

    @FindBy(css = ".subtotal.value")
    private WebElement totalProductsValue;

    @FindBy(css = ".btn-secondary")
    private WebElement continueShoppingBtn;

    @FindBy(css = "a.btn-primary")
    private WebElement proceedToCheckoutBtn;


    public ProductPopupCartPage(WebDriver driver) {
        super(driver);
    }


    public int getProductQuantity() {
        return Integer.parseInt(productQuantity.getText());
    }

    public float getProductPrice() {
        return Float.parseFloat(productPrice.getText().substring(1, 5));
    }

    public float getTotalProductsValue() {
        return Float.parseFloat(totalProductsValue.getText().substring(1));
    }

    public String getProductName() {
        waitToBeVisible(productName);
        return productName.getText();
    }

    public int getCartTotalCount() {
        return Integer.parseInt(cartTotalCount.getText().replaceAll("[^0-9?!]", ""));
    }

    public void clickContinueShoppingBtn() {
        click(continueShoppingBtn);
    }

    public void clickProceedToCheckoutBtn() {
        click(proceedToCheckoutBtn);
    }
}