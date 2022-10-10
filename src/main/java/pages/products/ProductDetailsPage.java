package pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.Random;

public class ProductDetailsPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(ProductDetailsPage.class);


    @FindBy(id = "quantity_wanted")
    private WebElement quantityField;

    @FindBy(css = ".add-to-cart")
    private WebElement addToCartBtn;

    @FindBy(css = "h1[itemprop=name]")
    private WebElement productName;

    @FindBy(css = "[itemprop=price]")
    private WebElement currentPrice;


    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailsPage setProductQuantity(int productQuantity) {
        quantityField.clear();
        sendKeys(quantityField, String.valueOf(productQuantity));
        return this;
    }

    public int setRandomProductQuantityRange(int minQuantity, int maxQuantity) {
        Random random = new Random();
        int rndProductQuantity = random.nextInt(minQuantity, maxQuantity);
        sendKeysWithClear(quantityField, String.valueOf(rndProductQuantity));
        return rndProductQuantity;
    }

    public ProductDetailsPage clickAddProductToCartBtn() {
        click(addToCartBtn);
        return this;
    }

    public String getProductName() {
        return productName.getText();
    }

    public float getCurrentPrice() {
        return Float.parseFloat(currentPrice.getText().substring(1));
    }
}