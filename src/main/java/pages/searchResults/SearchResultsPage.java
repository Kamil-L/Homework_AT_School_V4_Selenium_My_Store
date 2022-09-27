package pages.searchResults;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#js-product-list")
    private List<WebElement> productsList;

    @FindBy(css = ".product-title")
    private WebElement productName;

    public String getProductName () {
        return productName.getText();
    }
}