package tests.productAndCategoriesTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CategoryDetailsPage;
import pages.FiltersSideMenuPage;
import pages.ProductsGridPage;
import pages.home.TopMenuPage;
import tests.TestBase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoriesTest extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(CategoriesTest.class);

    ProductsGridPage productsGridPage = new ProductsGridPage(driver);
    TopMenuPage topMenuPage = new TopMenuPage(driver);
    CategoryDetailsPage categoryDetailsPage = new CategoryDetailsPage(driver);
    FiltersSideMenuPage filtersSideMenuPage = new FiltersSideMenuPage(driver);

    @Test
    @DisplayName("Check for name of opened category")
    @Tag("TesterSii")
    @Tag("productAndCategoriesTests")
    @Tag("CategoriesTest")
    public void shouldNameOfOpenedCategoryMatchesWhatWeClicked() {
        log.info("<<<<< Starting test >>>>>");
        List<WebElement> mainCategories = topMenuPage.getListOfMainCategoryElements();
        log.info("<<<<< Get main category list >>>>>");
        for (int i = 0; i < mainCategories.size(); i++) {
            mainCategories.get(i).click();
            log.info("<<<<< Click main category: " + i + " >>>>>");
            String expectedCategoryName = categoryDetailsPage.getCategoryTitle().getText();
            log.info("<<<<< Expected category name: " + expectedCategoryName+ " >>>>>");
            String actualCategoryName = topMenuPage.getMainCategoryElement().getText();
            log.info("<<<<< Actual category name: " + actualCategoryName + " >>>>>");
            log.info("<<<<< End test>>>>> ");
            assertThat(actualCategoryName).isEqualTo(expectedCategoryName);
        }
    }

    @Test
    @DisplayName("Check for display filters side menu for Categories")
    @Tag("TesterSii")
    @Tag("productAndCategoriesTests")
    @Tag("CategoriesTest")
    public void shouldDisplayFiltersSideMenu() {
        log.info("<<<<< Starting test >>>>>");
        List<WebElement> mainCategories = topMenuPage.getListOfMainCategoryElements();
        log.info("<<<<< Get main category list >>>>>");
        for (int i = 0; i < mainCategories.size(); i++) {
            mainCategories.get(i).click();
            log.info("<<<<< Click main category: " + i + " >>>>>");
            log.info("<<<<< End test >>>>>");
            assertThat(filtersSideMenuPage.checkForSearchFiltersToBeDisplayed());
        }
    }

    @Test
    @DisplayName("Check if label contains correct number of products in category ")
    @Tag("TesterSii")
    @Tag("productAndCategoriesTests")
    @Tag("CategoriesTest")
    public void shouldDisplayCorrectNumberOfProductsInCategoryOnLabelOfThatCategory() {
        log.info("<<<<< Starting test >>>>>");
        List<WebElement> mainCategories = topMenuPage.getListOfMainCategoryElements();
        log.info("<<<<< Get main category list >>>>>");
        for (int i = 0; i < mainCategories.size(); i++) {
            mainCategories.get(i).click();
            log.info("<<<<< Click main category: " + i + " >>>>>");
            int actualProductQuantity = productsGridPage.getQuantityOfProductInCategory();
            log.info("<<<<< Get actual product quantity: " + actualProductQuantity + " >>>>>");
            int expectedProductQuantity = productsGridPage.getQuantityOfProductFromLabel();
            log.info("<<<<< Get expected product quantity: " + expectedProductQuantity + " >>>>>");
            log.info("<<<<< End test >>>>> ");
            assertThat(actualProductQuantity).isEqualTo(expectedProductQuantity);
        }
    }
}