package tests.productAndCategoriesTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.FiltersSideMenuPage;
import pages.ProductsGridPage;
import pages.home.TopMenuPage;
import tests.TestBase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FiltersTest extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(FiltersTest.class);

    TopMenuPage topMenuPage = new TopMenuPage(driver);
    FiltersSideMenuPage filtersSideMenuPage = new FiltersSideMenuPage(driver);
    ProductsGridPage productsGridPage = new ProductsGridPage(driver);

    @Test
    @DisplayName("Check if list of products matches selected price list")
    @Tag("TesterSii")
    @Tag("productAndCategoriesTests")
    @Tag("FiltersTest")
    public void shouldDisplayListOfProductsMatchSelectedPriceListRange() {
        log.info("<<<<< Starting test >>>>>");
        topMenuPage.clickOnArtCategory();
        log.info("<<<<< Move to art subcategories >>>>>");
        int minPriceValue = 9;
        int maxPriceValue = 10;
        filtersSideMenuPage.setPriceFilterValues(minPriceValue,maxPriceValue);
        log.info("<<<<< Set minimum product price: " + minPriceValue + " >>>>>");
        log.info("<<<<< Set maximum product price: " + maxPriceValue + " >>>>>");
        List<Integer> filteredProductsPrice = productsGridPage.getProductsPrices(productsGridPage.getProductPrice());
        for (int productPrice : filteredProductsPrice) {
            log.info("Price of product: " + productPrice + " filters' range: " + minPriceValue + " and " + maxPriceValue);
            log.info("Filters' range: " + minPriceValue + " - " + maxPriceValue);
            log.info("<<<<< End test>>>>> ");
            assertThat(productPrice).isBetween(minPriceValue, maxPriceValue);
        }
    }

    @Test
    @DisplayName("Check if list is refreshed with all products")
    @Tag("TesterSii")
    @Tag("productAndCategoriesTests")
    @Tag("FiltersTest")
    public void shouldDisplayAllProductsAfterClearFilterClick() {
        log.info("<<<<< Starting test >>>>>");
        topMenuPage.clickOnArtCategory();
        log.info("<<<<< Move to art subcategories >>>>>");
        int expectedQuantityOfProd = productsGridPage.getProductsQuantity();
        log.info("<<<<< Get expected quantity of products: " + expectedQuantityOfProd + " >>>>>");
        int minPriceValue = 9;
        int maxPriceValue = 10;
        filtersSideMenuPage.setPriceFilterValues(minPriceValue,maxPriceValue);
        log.info("<<<<< Set minimum product price: " + minPriceValue + " >>>>>");
        log.info("<<<<< Set maximum product price: " + maxPriceValue + " >>>>>");
        filtersSideMenuPage.clickClearFilterButton();
        log.info("<<<<< Clear picked filters' range >>>>>");
        int actualQuantityOfProd = productsGridPage.getProductsQuantity();
        log.info("<<<<< Get actual quantity of products: " + actualQuantityOfProd + " >>>>>");
        log.info("<<<<< End test>>>>> ");
        assertThat(actualQuantityOfProd).isEqualTo(expectedQuantityOfProd);
    }
}