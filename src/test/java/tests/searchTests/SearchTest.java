package tests.searchTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.ProductsGridPage;
import pages.home.BodyPage;
import pages.home.TopMenuPage;
import pages.searchResults.SearchResultsPage;
import tests.TestBase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(SearchTest.class);

    BodyPage bodyPage = new BodyPage(driver);
    ProductsGridPage productsGridPage = new ProductsGridPage(driver);
    TopMenuPage topMenuPage = new TopMenuPage(driver);
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

    @Test
    @DisplayName("Checking name of random product in search result")
    @Tag("TesterSii")
    @Tag("searchTests")
    public void shouldNameOfProductInSearchResultMatchesProductWeSearchFor() {
        log.info("<<<<< Starting test >>>>>");
        bodyPage.getAllProducts();
        log.info("<<<<< Get all products >>>>>");
        productsGridPage.getListOfProductsName();
        String expectedRndProductName = productsGridPage.getRandomProductName();
        log.info("<<<<< Get random product name: " + expectedRndProductName + ">>>>> ");
        topMenuPage.typeProductNameIntoSearchField(expectedRndProductName);
        log.info("<<<<< Type expected random product name into search field >>>>>");
        topMenuPage.clickSearchSubmitButton();
        log.info("<<<<< Click search submit button >>>>>");
        String actualSearchResultProductName = searchResultsPage.getProductName();
        log.info("<<<<< Get actual random product name: " + actualSearchResultProductName + ">>>>> ");
        log.info("<<<<< End test >>>>> ");
        assertThat(actualSearchResultProductName).isEqualTo(expectedRndProductName);
    }

    @Test
    @DisplayName("Checking for result in dropdown search field")
    @Tag("TesterSii")
    @Tag("searchTests")
    void shouldResultInDropdownSearchFieldContainsExpectedTextWeTypeInSearchInput() {
        log.info("<<<<< Starting test >>>>>");
        String expectedName = topMenuPage.typeProductNameIntoSearchField("HUMMINGBIRD");
        log.info("<<<<< Get expected product name: " + expectedName + ">>>>> ");
        List<String> searchResultsDropdownList = topMenuPage.getSearchResultDropdownItem();
        for (String searchResultDropdownItem : searchResultsDropdownList) {
            String actualName = String.valueOf(searchResultDropdownItem.contains(expectedName));
            log.info("<<<<< Get actual product name: " + actualName + ">>>>> ");
            log.info("<<<<< End test >>>>> ");
            assertThat(actualName).isEqualTo(expectedName);
        }
    }
}