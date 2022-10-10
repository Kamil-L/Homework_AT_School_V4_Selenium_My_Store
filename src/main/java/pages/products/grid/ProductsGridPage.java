package pages.products.grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ProductsGridPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(ProductsGridPage.class);

    public ProductsGridPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product")
    private List<WebElement> products;

    @FindBy(css = ".product-title")
    private WebElement productName;

    @FindBy(css = ".product-title")
    private List<WebElement> productsNames;

    @FindBy(css = ".product")
    private WebElement product;

    @FindBy(css = ".total-products")
    private WebElement totalProductsLabel;


    public List<ProductGridMiniaturePage> getProducts() {
        List<ProductGridMiniaturePage> products = new ArrayList<>();
        for (WebElement product : this.products) {
            products.add(new ProductGridMiniaturePage(product));
        }
        return products;
    }

    public List<Integer> getProductsCurrentPrices() {
        List<Integer> productsCurrentPrices = new ArrayList<>();
        for (ProductGridMiniaturePage productCurrentPrice : getProducts()) {
            productsCurrentPrices.add(Integer.valueOf(productCurrentPrice.getProductCurrentPrice()));
        }
        return productsCurrentPrices;
    }

    public String getProductName() {
        return productName.getText();
    }

    public void pickExpectedProduct(String expectedName) {
        for (WebElement product : productsNames) {
            String productName = product.getText();
            if (Objects.equals(productName, expectedName)) {
                click(product);
                break;
            }
        }
    }

    public ProductsGridPage pickRandomProduct() {
        WebElement rndProduct = getRandomElement(products);
        click(rndProduct);
        return this;
    }

    public String getRandomProductName() {
        List<String> productsName = new ArrayList<>();
        for (ProductGridMiniaturePage product : getProducts()) {
            productsName.add(product.getProductName());
        }
        Random random = new Random();
        int rndProductIndex = random.nextInt(productsName.size());
        String rndProductName = productsName.get(rndProductIndex);
        return rndProductName;
    }

    public int getProductsQuantitySize() {
        return getProducts().size();
    }

    public int getQuantityOfProductFromLabel() {
        return Integer.parseInt(totalProductsLabel.getText().replaceAll("\\D+", ""));
    }
}