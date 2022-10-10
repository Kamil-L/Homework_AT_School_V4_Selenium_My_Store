package tests.productAndCategories;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FiltersTest extends Pages {

    private static final Logger log = LoggerFactory.getLogger(FiltersTest.class);

    @Test
    //@RepeatedTest(10)
    @DisplayName("Check if list of products matches selected price list")
    @Tag("TesterSii")
    @Tag("productAndCategories")
    @Tag("FiltersTest")
    public void shouldDisplayListOfProductsMatchSelectedPriceListRange() {

        headerPage
                .clickOnArtCategory();
        int minPriceValue = 9;
        int maxPriceValue = 10;
        filtersPage
                .setPriceFilterValues(minPriceValue,maxPriceValue);

        List<Integer> filteredProductsPrice = productsGridPage.getProductsCurrentPrices();
        for (int filteredProductPrice : filteredProductsPrice){
            log.info("Price of product: " + filteredProductPrice + " filters' range: " + minPriceValue + " and " + maxPriceValue);
            log.info("Filters' range: " + minPriceValue + " - " + maxPriceValue);
            assertThat(filteredProductPrice).isBetween(minPriceValue, maxPriceValue);
        }
    }

    @Test
    //@RepeatedTest(10)
    @DisplayName("Check if list is refreshed with all products")
    @Tag("TesterSii")
    @Tag("productAndCategories")
    @Tag("FiltersTest")
    public void shouldDisplayAllProductsAfterClearFilterClick() {

        headerPage
                .clickOnArtCategory();

        int expectedQuantityOfProd =
        productsGridPage
                .getProductsQuantitySize();
        log.info("<<<<< Get expected quantity of products: " + expectedQuantityOfProd + " >>>>>");
        int minPriceValue = 9;
        int maxPriceValue = 10;
        filtersPage
                .setPriceFilterValues(minPriceValue,maxPriceValue);
        filtersPage
                .clickClearFilterButton();
        int actualQuantityOfProd =
        productsGridPage
                .getProductsQuantitySize();
        log.info("<<<<< Get actual quantity of products: " + actualQuantityOfProd + " >>>>>");

        assertThat(actualQuantityOfProd).isEqualTo(expectedQuantityOfProd);
    }
}