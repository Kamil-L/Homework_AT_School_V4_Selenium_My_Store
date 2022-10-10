package pages.order.basket;

import models.OrderBasketDetails;
import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(BasketPage.class);

    @FindBy(css = ".cart-item")
    private List<WebElement> allItems;

    @FindBy(css = ".remove-from-cart")
    private WebElement removeItem;

    @FindBy(css = ".remove-from-cart")
    private List<WebElement> removeItems;

    @FindBy(css = ".cart-overview")
    private WebElement cartItem;

    @FindBy(css = ".cart-summary")
    private WebElement cartSummary;

    @FindBy(className = "no-items")
    private WebElement noItemsLabel;


    public BasketPage(WebDriver driver) {
        super(driver);
    }


    public List<BasketItemsRowPage> getAllItemsFromList() {
        List<BasketItemsRowPage> allItems = new ArrayList<>();
        for (WebElement item : this.allItems) {
            allItems.add(new BasketItemsRowPage(item));
        }
        return allItems;
    }

    public List<Product> getAllProductsFromBasket() {
        List<BasketItemsRowPage> allItemsOnBasket = getAllItemsFromList();
        List<Product> products = new ArrayList<>();
        for (BasketItemsRowPage cartItem : allItemsOnBasket) {
            String productName = cartItem.getProductName();
            int productQuantity = cartItem.getProductQuantity();
            float productCurrentPrice = cartItem.getProductCurrentPrice();
            double productTotalPrice = cartItem.getProductTotalPrice();
            products.add(new Product(productName, productQuantity, productCurrentPrice, productTotalPrice));
        }
        return products;
    }

    public double getTotalProductsPriceFromItemsList() {
        double totalProductsPrice = 0;
        for (BasketItemsRowPage item : getAllItemsFromList()) {
            double itemTotalProductsPrice = item.getProductTotalPrice();
            totalProductsPrice += itemTotalProductsPrice;
        }
        return Math.round(totalProductsPrice * 1000000000) / 1000000000.0;
    }

    public OrderBasketDetails getBasket() {
        List<Product> allProductsInBasket = getAllProductsFromBasket();
        return new OrderBasketDetails(allProductsInBasket);
    }

    public BasketPage removeItem() {
        click(removeItem);
        waitToBeInvisible(removeItems.get(removeItems.size()- 1));
        return this;
    }

    public String getEmptyBasketValue() {
        return noItemsLabel.getText();
    }
}