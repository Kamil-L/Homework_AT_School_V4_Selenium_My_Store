package tests.productAndCategories;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoriesTest extends Pages {

    private static final Logger log = LoggerFactory.getLogger(CategoriesTest.class);

    @Test
    //@RepeatedTest(10)
    @DisplayName("Check for name of opened category")
    @Tag("TesterSii")
    @Tag("productAndCategories")
    @Tag("CategoriesTest")
    public void shouldNameOfOpenedCategoryMatchesWhatWeClicked() {

        for (int i = 0; i < headerPage.mainCategoriesItemsSize(); i++) {
            headerPage
                    .clickOnMainCategory(i);
            String expectedCategoryName =
            categoryDetailsPage
                    .getCategoryTitle(i);
            log.info("<<<<< Expected category name: " + expectedCategoryName+ " >>>>>");
            String actualCategoryName =
            headerPage
                    .getMainCategory();
            log.info("<<<<< Actual category name: " + actualCategoryName + " >>>>>");

            assertThat(actualCategoryName).isEqualTo(expectedCategoryName);
        }
    }

    @Test
    //@RepeatedTest(10)
    @DisplayName("Check for display filters side menu for Categories")
    @Tag("TesterSii")
    @Tag("productAndCategories")
    @Tag("CategoriesTest")
    public void shouldDisplayFiltersSideMenu() {

        for (int i = 0; i < headerPage.mainCategoriesItemsSize(); i++) {
            headerPage
                    .clickOnMainCategory(i);
            log.info("<<<<< Click main category: " + i + " >>>>>");

            assertThat(filtersPage.checkForSearchFiltersToBeDisplayed()).isFalse();
        }
    }

    @Test
    //@RepeatedTest(10)
    @DisplayName("Check if label contains correct number of products in category ")
    @Tag("TesterSii")
    @Tag("productAndCategories")
    @Tag("CategoriesTest")
    public void shouldDisplayCorrectNumberOfProductsInCategoryOnLabelOfThatCategory() {

        for (int i = 0; i < headerPage.mainCategoriesItemsSize();i++) {
            headerPage
                    .clickOnMainCategory(i);
            int actualProductQuantity =
            productsGridPage
                    .getProductsQuantitySize();
            log.info("<<<<< Get actual product quantity: " + actualProductQuantity + " >>>>>");
            int expectedProductQuantity =
            productsGridPage
                    .getQuantityOfProductFromLabel();
            log.info("<<<<< Get expected product quantity: " + expectedProductQuantity + " >>>>>");

            assertThat(actualProductQuantity).isEqualTo(expectedProductQuantity);
        }
    }
}