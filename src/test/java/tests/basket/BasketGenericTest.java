package tests.basket;

import base.Pages;
import models.OrderBasketDetails;
import models.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BasketGenericTest extends Pages {

    OrderBasketDetails orderBasketDetails = new OrderBasketDetails();

    @Test
    //@RepeatedTest(10)
    @DisplayName("Check if random products in basket are added/clear correctly")
    @Tag("TesterSii")
    @Tag("basket")
    @Tag("BasketGenericTest")
    public void shouldAddRandomProductsAndClearBasketCorrectly() {

        for (int i = 1; i <= 5; i++) {
            homePage
                    .clickAllProductsLink();
            productsGridPage
                    .pickRandomProduct();
            productDetailsPage
                    .setRandomProductQuantityRange(1, 5);
            productDetailsPage
                    .clickAddProductToCartBtn();
            orderBasketDetails.
                    addDetailsOfPickedProductsToList(productPopupCartPage);
            productPopupCartPage
                    .clickProceedToCheckoutBtn();
            homePage
                    .goToHomePage();
        }
        OrderBasketDetails actualOrderBasket = orderBasketDetails.getBasket();
            headerPage
                    .goToBasket();
        OrderBasketDetails expectedOrderBasket = basketPage.getBasket();

        assertThat(actualOrderBasket).usingRecursiveComparison().isEqualTo(expectedOrderBasket);
        assertThat(basketPage.getTotalProductsPriceFromItemsList()).
                isEqualTo(basketSummaryPage.getTotalItemsPrice());

        while (!orderBasketDetails.isProductsOrderListEmpty()) {
            Product firstItem = orderBasketDetails.getProducts().get(0);
            orderBasketDetails
                    .getProducts().remove(firstItem);
            OrderBasketDetails actualBasketAfterItemRemoval = orderBasketDetails.getBasket();
            basketPage
                    .removeItem();
            OrderBasketDetails expectedBasketAfterItemRemoval = orderBasketDetails.getBasket();

            assertThat(actualBasketAfterItemRemoval).usingRecursiveComparison().isEqualTo(expectedBasketAfterItemRemoval);
        }
        assertThat(basketPage.getEmptyBasketValue()).isEqualTo("There are no more items in your cart");
    }
}