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

public class SubCategoriesTest extends TestBase {


    private static final Logger log = LoggerFactory.getLogger(SubCategoriesTest.class);

    ProductsGridPage productsGridPage = new ProductsGridPage(driver);
    TopMenuPage topMenuPage = new TopMenuPage(driver);
    CategoryDetailsPage categoryDetailsPage = new CategoryDetailsPage(driver);
    FiltersSideMenuPage filtersSideMenuPage = new FiltersSideMenuPage(driver);

    @Test
    @DisplayName("Check for name of opened subcategory of clothes")
    @Tag("TesterSii")
    @Tag("productAndCategoriesTests")
    @Tag("SubCategoriesTest")
    public void shouldNameOfOpenedSubCategoryOfClothesMatchesWhatWeClicked() {
        log.info("<<<<< Starting test >>>>>");
        topMenuPage.clickOnClothesCategory();
        log.info("<<<<< Move to clothes subcategories >>>>>");
        List<WebElement> clothesSubCategories = categoryDetailsPage.getAllSubCategories();
        for (int i = 0; i < clothesSubCategories.size(); i++) {
            String actualSubCategoryName = clothesSubCategories.get(i).getText().toUpperCase();
            log.info("<<<<< Get actual subcategory name: " + actualSubCategoryName + " >>>>>");
            clothesSubCategories.get(i).click();
            log.info("<<<<< Click subcategory: " + i + " >>>>>");
            String expectedSubCategoryName = categoryDetailsPage.getCategoryTitle().getText().toUpperCase();
            log.info("<<<<< Get expected subcategory name: " + expectedSubCategoryName + " >>>>>");
            categoryDetailsPage.goToPreviousPage();
            log.info("<<<<< Go to previous page >>>>>");
            log.info("<<<<< End test>>>>> ");
            assertThat(actualSubCategoryName).isEqualTo(expectedSubCategoryName);
        }
    }

    @Test
    @DisplayName("Check for name of opened subcategory of accessories")
    @Tag("TesterSii")
    @Tag("productAndCategoriesTests")
    @Tag("SubCategoriesTest")
    public void shouldNameOfOpenedSubCategoryOfAccessoriesMatchesWhatWeClicked() {
        log.info("<<<<< Starting test >>>>>");
        topMenuPage.clickOnAccessoriesCategory();
        log.info("<<<<< Move to accessories subcategories >>>>>");
        List<WebElement> accessoriesSubCategories = categoryDetailsPage.getAllSubCategories();
        for (int i = 0; i < accessoriesSubCategories.size(); i++) {
            String actualSubCategoryName = accessoriesSubCategories.get(i).getText().toUpperCase();
            log.info("<<<<< Get actual subcategory name: " + actualSubCategoryName + " >>>>>");
            accessoriesSubCategories.get(i).click();
            log.info("<<<<< Click subcategory: " + i + " >>>>>");
            String expectedSubCategoryName = categoryDetailsPage.getCategoryTitle().getText().toUpperCase();
            log.info("<<<<< Get expected subcategory name: " + expectedSubCategoryName + " >>>>>");
            categoryDetailsPage.goToPreviousPage();
            log.info("<<<<< Go to previous page >>>>>");
            log.info("<<<<< End test>>>>> ");
            assertThat(actualSubCategoryName).isEqualTo(expectedSubCategoryName);
        }
    }


    @Test
    @DisplayName("Check for display filters side menu for subcategory of clothes")
    @Tag("TesterSii")
    @Tag("productAndCategoriesTests")
    @Tag("SubCategoriesTest")
    public void shouldDisplayFiltersSideMenuForSubCategoriesOfClothes() {
        log.info("<<<<< Starting test >>>>>");
        topMenuPage.clickOnClothesCategory();
        log.info("<<<<< Move to clothes subcategories >>>>>");
        List<WebElement> clothesSubCategories = categoryDetailsPage.getAllSubCategories();
        for (int i = 0; i < clothesSubCategories.size(); i++) {
            clothesSubCategories.get(i).click();
            log.info("<<<<< Click subcategory: " + i + " >>>>>");
            categoryDetailsPage.goToPreviousPage();
            log.info("<<<<< Go to previous page >>>>>");
            log.info("<<<<< End test>>>>> ");
            assertThat(filtersSideMenuPage.checkForSearchFiltersToBeDisplayed());
        }
    }

    @Test
    @DisplayName("Check for display filters side menu for subcategory of accessories")
    @Tag("TesterSii")
    @Tag("productAndCategoriesTests")
    @Tag("SubCategoriesTest")
    public void shouldDisplayFiltersSideMenuForSubCategoriesOfAccessories() {
        log.info("<<<<< Starting test >>>>>");
        topMenuPage.clickOnAccessoriesCategory();
        log.info("<<<<< Move to accessories subcategories >>>>>");
        List<WebElement> accessoriesSubCategories = categoryDetailsPage.getAllSubCategories();
        for (int i = 0; i < accessoriesSubCategories.size(); i++) {
            accessoriesSubCategories.get(i).click();
            log.info("<<<<< Click subcategory: " + i + " >>>>>");
            categoryDetailsPage.goToPreviousPage();
            log.info("<<<<< Go to previous page >>>>>");
            log.info("<<<<< End test>>>>> ");
            assertThat(filtersSideMenuPage.checkForSearchFiltersToBeDisplayed());
        }
    }


    @Test
    @DisplayName("Check if label contains correct number of products in subcategory of clothes ")
    @Tag("TesterSii")
    @Tag("productAndCategoriesTests")
    @Tag("SubCategoriesTest")
    public void shouldDisplayCorrectNumberOfProductsInClothesSubCategoryOnLabelOfThatSubCategory() {
        log.info("<<<<< Starting test >>>>>");
        topMenuPage.clickOnClothesCategory();
        log.info("<<<<< Move to clothes subcategories >>>>>");
        List<WebElement> clothesSubCategories = categoryDetailsPage.getAllSubCategories();
        for (int i = 0; i < clothesSubCategories.size(); i++) {
            clothesSubCategories.get(i).click();
            log.info("<<<<< Click subcategory: " + i + " >>>>>");
            int actualProductQuantity = productsGridPage.getQuantityOfProductInCategory();
            log.info("<<<<< Get actual product quantity: " + actualProductQuantity + " >>>>>");
            int expectedProductQuantity = productsGridPage.getQuantityOfProductFromLabel();
            log.info("<<<<< Get expected product quantity: " + expectedProductQuantity + " >>>>>");
            categoryDetailsPage.goToPreviousPage();
            log.info("<<<<< Go to previous page >>>>>");
            log.info("<<<<< End test>>>>> ");
            assertThat(actualProductQuantity).isEqualTo(expectedProductQuantity);
        }
    }

    @Test
    @DisplayName("Check if label contains correct number of products in subcategory of accessories ")
    @Tag("TesterSii")
    @Tag("productAndCategoriesTests")
    @Tag("SubCategoriesTest")
    public void shouldDisplayCorrectNumberOfProductsInAccessoriesSubCategoryOnLabelOfThatSubCategory() {
        log.info("<<<<< Starting test >>>>>");
        topMenuPage.clickOnAccessoriesCategory();
        log.info("<<<<< Move to accessories subcategories >>>>>");
        List<WebElement> accessoriesSubCategories = categoryDetailsPage.getAllSubCategories();
        for (int i = 0; i < accessoriesSubCategories.size(); i++) {
            accessoriesSubCategories.get(i).click();
            log.info("<<<<< Click subcategory: " + i + " >>>>>");
            int actualProductQuantity = productsGridPage.getQuantityOfProductInCategory();
            log.info("<<<<< Get actual product quantity: " + actualProductQuantity + " >>>>>");
            int expectedProductQuantity = productsGridPage.getQuantityOfProductFromLabel();
            log.info("<<<<< Get expected product quantity: " + expectedProductQuantity + " >>>>>");
            categoryDetailsPage.goToPreviousPage();
            log.info("<<<<< Go to previous page >>>>>");
            log.info("<<<<< End test>>>>> ");
            assertThat(actualProductQuantity).isEqualTo(expectedProductQuantity);
        }
    }
}