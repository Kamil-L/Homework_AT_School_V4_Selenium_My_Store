package tests.basket;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartTest extends Pages {

    @Test
    //@RepeatedTest(10)
    @DisplayName("Checking if products are added to shopping cart successfully")
    @Tag("TesterSii")
    @Tag("basket")
    @Tag("ShoppingCartTest")
    public void shouldAddedProductToShoppingCartSuccessfully() {

        headerPage
                .clickOnArtCategory();
        String expectedProductName = "THE BEST IS YET POSTER";
        productsGridPage
                .pickExpectedProduct(expectedProductName);
        int expectedProductQuantity = 3;
        productDetailsPage
                .setProductQuantity(expectedProductQuantity);
        productDetailsPage
                .clickAddProductToCartBtn();

        float expectedCurrentPrice = productDetailsPage.getCurrentPrice();
        float expectedTotalProductsValue = expectedCurrentPrice * expectedProductQuantity;

        assertThat(productPopupCartPage.getProductName()).isEqualTo(expectedProductName);
        assertThat(productPopupCartPage.getProductPrice()).isEqualTo(expectedCurrentPrice);
        assertThat(productPopupCartPage.getProductQuantity()).isEqualTo(expectedProductQuantity);
        assertThat(productPopupCartPage.getCartTotalCount()).isEqualTo(expectedProductQuantity);
        assertThat(productPopupCartPage.getTotalProductsValue()).isEqualTo(expectedTotalProductsValue);

        productPopupCartPage
                .clickContinueShoppingBtn();

        float cartTotalProductsValue = headerPage.getCartProductsAmount();

        assertThat(cartTotalProductsValue).isEqualTo(expectedProductQuantity);
    }
}