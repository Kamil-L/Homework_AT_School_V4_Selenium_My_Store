package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductsGridPage extends BasePage {

    public ProductsGridPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product")
    private List<WebElement> product;

    @FindBy(css = ".product-title")
    private List<WebElement> productName;

    @FindBy(css = ".price")
    private WebElement currentPrice;

    @FindBy(css = ".pagination a")
    private List<WebElement> pageAllNav;

    @FindBy(css = ".pagination a.next")
    private WebElement pageNextNav;

    @FindBy(css = ".pagination a.previous")
    private WebElement pagePreviousNav;

    @FindBy(css = ".total-products")
    private WebElement totalProductsLabel;


    public void getNextPage() {
        click(pageNextNav);
    }

    public void getPreviousPage() {
        click(pagePreviousNav);
    }

    public List<WebElement> getAllProducts() {
        return product;
    }

    public int getProductsQuantity() {
        return getAllProducts().size();
    }

    public List<Integer> getProductsPrices(int productPrice) {
        List<Integer> pricesOfProducts = new ArrayList<>();
        for (int i = 0; i < product.size(); i++) {
            pricesOfProducts.add(productPrice);
        }
        return pricesOfProducts;
    }

    public List<String> getListOfProductsName() {
        List<String> productsList = new ArrayList<>();
        List<WebElement> pageListNameElements = pageAllNav;
        if (!pageListNameElements.isEmpty()) {
            for (int i = 0; i < pageListNameElements.size(); i++) {
                waitForVisibilityOfAllElements(productName);
                String title = pageAllNav.get(i).getAttribute("title");
                if (title.equals("Next")) {
                    break;
                } else {
                    for (WebElement productNameElement : productName) {
                        productsList.add(productNameElement.getText());
                    }
                }
            }
        } else {
            for (WebElement productNameElement : productName) {
                productsList.add(productNameElement.getText());
            }
        }
        return productsList;
    }
    public int getQuantityOfProductInCategory() {
        int size = getListOfProductsName().size();
        return size;
    }

    public int getQuantityOfProductFromLabel() {
        int quantityOfProductFromLabel = Integer.parseInt(totalProductsLabel.getText().replaceAll("\\D+", ""));
        return quantityOfProductFromLabel;
    }

    public int getProductPrice() {
        String productPriceName = currentPrice.getText();
        int productPrice = Integer.parseInt(productPriceName.replaceAll("\\$|\\.00", ""));
        return productPrice;
    }

    public String getRandomProductName() {
        return getRandomItem(getListOfProductsName());
    }

}