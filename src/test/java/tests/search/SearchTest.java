package tests.search;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.products.grid.ProductGridMiniaturePage;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends Pages {

    private static final Logger log = LoggerFactory.getLogger(SearchTest.class);

    @Test
    //@RepeatedTest(10)
    @DisplayName("Checking name of random product in search result")
    @Tag("TesterSii")
    @Tag("search")
    @Tag("SearchTest")
    public void shouldNameOfProductInSearchResultMatchesProductWeSearchFor() {

        homePage
                .clickAllProductsLink();
        String expectedRndProductName =
                productsGridPage
                        .getRandomProductName();
        headerPage
                .typeProductNameIntoSearchField(expectedRndProductName);
        log.info("<<<<< Type expected random product name: "  + expectedRndProductName + " into search field >>>>>");
        headerPage
                .clickSearchSubmitBtn();

        String actualProductName =
        productsGridPage
                .getProductName();

        for (ProductGridMiniaturePage product : productsGridPage.getProducts()) {

            log.info("<<<<< Get actual random product name: " + product.getProductName() + ">>>>> ");
            assertThat(product.getProductName()).isEqualTo(expectedRndProductName);
        }
    }

    @Test
    //@RepeatedTest(10)
    @DisplayName("Checking for result in dropdown search field")
    @Tag("TesterSii")
    @Tag("searchTests")
    void shouldResultInDropdownSearchFieldContainsExpectedTextWeTypeInSearchInput() {

        String expectedName =
        headerPage
                .typeProductNameIntoSearchField("HUMMINGBIRD");
        log.info("<<<<< Get expected product name: " + expectedName + ">>>>> ");

        for (String searchResultDropdownItem : headerPage.getSearchResultDropdownItem()) {
            String actualName = String.valueOf(searchResultDropdownItem.contains(expectedName));
            log.info("<<<<< Get actual product name: " + actualName + ">>>>> ");

            assertThat(actualName).isEqualTo(expectedName);
        }
    }
}