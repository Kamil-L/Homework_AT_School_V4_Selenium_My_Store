package pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.List;

public class CategoryDetailsPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(CategoryDetailsPage.class);


    public CategoryDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#js-product-list-header h1")
    private WebElement categoryTitle;

    @FindBy(css = "li[data-depth='0']>a")
    private List<WebElement> allSubCategories;

    @FindBy(css = "li[data-depth='0']>a")
    private WebElement subCategories;


    public CategoryDetailsPage goToPreviousPage() {
        driver.navigate().back();
        log.info("<<<<< Go to previous page >>>>>");
        return this;
    }

    public String getCategoryTitle(int i) {
        return categoryTitle.getText().toUpperCase();
    }

    public CategoryDetailsPage clickOnSubCategory(int i) {
        click(subCategories);
        return this;
    }

    public String getSubCategoryTitle(int i) {
        return subCategories.getText().toUpperCase();
    }

    public int subCategoriesItemsSize() {
        return allSubCategories.size();
    }
}