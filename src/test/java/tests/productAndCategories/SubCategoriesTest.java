package tests.productAndCategories;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class SubCategoriesTest extends Pages {


    private static final Logger log = LoggerFactory.getLogger(SubCategoriesTest.class);

    @Test
    //@RepeatedTest(10)
    @DisplayName("Check for name of opened subcategory of clothes")
    @Tag("TesterSii")
    @Tag("productAndCategories")
    @Tag("SubCategoriesTest")
    public void shouldNameOfOpenedSubCategoryOfClothesMatchesWhatWeClicked() {

        headerPage
                .clickOnClothesCategory();
        for (int i = 0; i < categoryDetailsPage.subCategoriesItemsSize(); i++) {
            String actualSubCategoryName =
            categoryDetailsPage
                    .getSubCategoryTitle(i);
            log.info("<<<<< Get actual subcategory name: " + actualSubCategoryName + " >>>>>");
            categoryDetailsPage
                    .clickOnSubCategory(i);
            log.info("<<<<< Click subcategory: " + i + " >>>>>");
            String expectedSubCategoryName =
            categoryDetailsPage
                    .getCategoryTitle(i);
            log.info("<<<<< Get expected subcategory name: " + expectedSubCategoryName + " >>>>>");
            categoryDetailsPage
                    .goToPreviousPage();

            assertThat(actualSubCategoryName).isEqualTo(expectedSubCategoryName);
        }
    }

    @Test
    //@RepeatedTest(10)
    @DisplayName("Check for name of opened subcategory of accessories")
    @Tag("TesterSii")
    @Tag("productAndCategories")
    @Tag("SubCategoriesTest")
    public void shouldNameOfOpenedSubCategoryOfAccessoriesMatchesWhatWeClicked() {

        headerPage
                .clickOnAccessoriesCategory();
        for (int i = 0; i < categoryDetailsPage.subCategoriesItemsSize(); i++) {
            String actualSubCategoryName =
                    categoryDetailsPage
                            .getSubCategoryTitle(i);
            log.info("<<<<< Get actual subcategory name: " + actualSubCategoryName + " >>>>>");
            categoryDetailsPage
                    .clickOnSubCategory(i);
            log.info("<<<<< Click subcategory: " + i + " >>>>>");
            String expectedSubCategoryName =
                    categoryDetailsPage
                            .getCategoryTitle(i);
            log.info("<<<<< Get expected subcategory name: " + expectedSubCategoryName + " >>>>>");
            categoryDetailsPage
                    .goToPreviousPage();

            assertThat(actualSubCategoryName).isEqualTo(expectedSubCategoryName);
        }
    }


    @Test
    //@RepeatedTest(10)
    @DisplayName("Check for display filters side menu for subcategory of clothes")
    @Tag("TesterSii")
    @Tag("productAndCategories")
    @Tag("SubCategoriesTest")
    public void shouldDisplayFiltersSideMenuForSubCategoriesOfClothes() {

        headerPage
                .clickOnClothesCategory();
        for (int i = 0; i < categoryDetailsPage.subCategoriesItemsSize(); i++) {
            categoryDetailsPage
                    .clickOnSubCategory(i);
            log.info("<<<<< Click subcategory: " + i + " >>>>>");
            categoryDetailsPage
                    .goToPreviousPage();

            assertThat(filtersPage.checkForSearchFiltersToBeDisplayed()).isFalse();
        }
    }

    @Test
    //@RepeatedTest(10)
    @DisplayName("Check for display filters side menu for subcategory of accessories")
    @Tag("TesterSii")
    @Tag("productAndCategories")
    @Tag("SubCategoriesTest")
    public void shouldDisplayFiltersSideMenuForSubCategoriesOfAccessories() {
        headerPage
                .clickOnAccessoriesCategory();
        for (int i = 0; i < categoryDetailsPage.subCategoriesItemsSize(); i++) {
            categoryDetailsPage
                    .clickOnSubCategory(i);
            log.info("<<<<< Click subcategory: " + i + " >>>>>");
            categoryDetailsPage
                    .goToPreviousPage();

            assertThat(filtersPage.checkForSearchFiltersToBeDisplayed()).isFalse();
        }
    }


    @Test
    //@RepeatedTest(10)
    @DisplayName("Check if label contains correct number of products in subcategory of clothes ")
    @Tag("TesterSii")
    @Tag("productAndCategories")
    @Tag("SubCategoriesTest")
    public void shouldDisplayCorrectNumberOfProductsInClothesSubCategoryOnLabelOfThatSubCategory() {
        headerPage
                .clickOnClothesCategory();
        for (int i = 0; i < categoryDetailsPage.subCategoriesItemsSize(); i++) {
            String actualSubCategoryName =
            categoryDetailsPage
                            .getSubCategoryTitle(i);
            log.info("<<<<< Get actual subcategory name: " + actualSubCategoryName + " >>>>>");
            categoryDetailsPage
                    .clickOnSubCategory(i);
            int actualProductQuantity =
            productsGridPage
                    .getProductsQuantitySize();
            log.info("<<<<< Get actual product quantity: " + actualProductQuantity + " >>>>>");
            int expectedProductQuantity =
            productsGridPage
                    .getQuantityOfProductFromLabel();
            log.info("<<<<< Get expected product quantity: " + expectedProductQuantity + " >>>>>");
            categoryDetailsPage
                    .goToPreviousPage();

            assertThat(actualProductQuantity).isEqualTo(expectedProductQuantity);
        }
    }

    @Test
    //@RepeatedTest(10)
    @DisplayName("Check if label contains correct number of products in subcategory of accessories ")
    @Tag("TesterSii")
    @Tag("productAndCategories")
    @Tag("SubCategoriesTest")
    public void shouldDisplayCorrectNumberOfProductsInAccessoriesSubCategoryOnLabelOfThatSubCategory() {
        headerPage
                .clickOnAccessoriesCategory();
        for (int i = 0; i < categoryDetailsPage.subCategoriesItemsSize(); i++) {
            String actualSubCategoryName =
            categoryDetailsPage
                            .getSubCategoryTitle(i);
            log.info("<<<<< Get actual subcategory name: " + actualSubCategoryName + " >>>>>");
            categoryDetailsPage
                    .clickOnSubCategory(i);
            int actualProductQuantity =
            productsGridPage.getProductsQuantitySize();
            log.info("<<<<< Get actual product quantity: " + actualProductQuantity + " >>>>>");
            int expectedProductQuantity =
            productsGridPage
                    .getQuantityOfProductFromLabel();
            log.info("<<<<< Get expected product quantity: " + expectedProductQuantity + " >>>>>");
            categoryDetailsPage
                    .goToPreviousPage();

            assertThat(actualProductQuantity).isEqualTo(expectedProductQuantity);
        }
    }
}