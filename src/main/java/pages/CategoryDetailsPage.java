package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryDetailsPage extends BasePage {

    public CategoryDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#js-product-list-header h1")
    private WebElement categoryTitle;

    @FindBy(css = "li[data-depth='0']>a")
    private List<WebElement> allSubCategories;


    public void goToPreviousPage() {
        driver.navigate().back();
    }

    public WebElement getCategoryTitle() {
        return categoryTitle;
    }

    public List<WebElement> getAllSubCategories() {
        return allSubCategories;
    }
}