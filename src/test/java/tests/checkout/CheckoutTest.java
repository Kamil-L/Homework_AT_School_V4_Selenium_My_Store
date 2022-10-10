package tests.checkout;

import base.Pages;
import models.Address;
import models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import providers.AddressFactory;
import providers.UserFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutTest extends Pages {

    @Test
    //@RepeatedTest(10)
    @DisplayName("Checking if details on order confirmation page are displayed correctly")
    @Tag("TesterSii")
    @Tag("checkout")
    @Tag("CheckoutTest")
    public void shouldDisplayDetailsOnOrderConfirmationPageCorrectly() {

        User user = UserFactory.getAlreadyRegisteredUser();
        Address address = AddressFactory.getSpecificInvoiceAddress();

        authenticationSteps
                .logInUser(user);
        headerPage
                .clickOnArtCategory();
        String expectedProductName = "THE BEST IS YET POSTER";
        productsGridPage
                .pickExpectedProduct(expectedProductName);
        productDetailsPage
                .setProductQuantity(1);
        productDetailsPage
                .clickAddProductToCartBtn();
        productPopupCartPage
                .clickProceedToCheckoutBtn();
        basketSummaryPage
                .clickProceedToCheckoutBtn();
        checkoutAddressesPage
                .clickAddDifferentInvoiceAddressBtn();
        checkoutAddressesPage
                .clickAddNewInvoiceAddressBtn();
        orderAddressPage
                .fillInvoiceAddressForm(address)
                .clickContinueBtn();
        checkoutShippingMethodPage
                .clickShippingContinueBtn();
        checkoutPaymentPage
                .selectPayByCheckRadioBtn()
                .acceptTermsOfService()
                .clickPlaceOrderBtn();

        assertThat(orderConfirmationItemsListPage.getItemName()).isEqualTo(expectedProductName);
        assertThat(orderConfirmationItemsListPage.getUnitPrice()).isEqualTo(29.00);
        assertThat(orderConfirmationItemsListPage.getQuantity()).isEqualTo(1);
        assertThat(orderConfirmationItemsListPage.getTotalProductPrice()).isEqualTo(29.00);
        assertThat(orderConfirmationItemsListPage.getShippingCost()).isEqualTo("Free");
        assertThat(orderConfirmationDetailsPage.getPaymentMethod()).isEqualTo("Payments by check");
        assertThat(orderConfirmationDetailsPage.getShippingMethod()).contains("TesterSii");
        assertThat(orderConfirmationDetailsPage.getCheckPaymentDetails()).contains("John Doe", "Washington");

    }


    @Test
    //@RepeatedTest(10)
    @DisplayName("Checking if order details on order details page are displayed correctly")
    @Tag("TesterSii")
    @Tag("checkout")
    @Tag("CheckoutTest")
    public void shouldDisplayOrderDetailsOnOrderDetailsPageCorrectly() {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        User user = UserFactory.getAlreadyRegisteredUser();
        Address invoiceAddress = AddressFactory.getSpecificInvoiceAddress();
        Address address = AddressFactory.getSpecificAddress();

        authenticationSteps
                .logInUser(user);
        headerPage
                .clickOnArtCategory();
        String expectedProductName = "THE BEST IS YET POSTER";
        productsGridPage
                .pickExpectedProduct(expectedProductName);
        productDetailsPage
                .setProductQuantity(1);
        productDetailsPage
                .clickAddProductToCartBtn();
        productPopupCartPage
                .clickProceedToCheckoutBtn();
        basketSummaryPage
                .clickProceedToCheckoutBtn();
        checkoutAddressesPage
                .clickAddDifferentInvoiceAddressBtn();
        checkoutAddressesPage
                .clickAddNewInvoiceAddressBtn();
        orderAddressPage
                .fillInvoiceAddressForm(invoiceAddress)
                .clickContinueBtn();
        checkoutShippingMethodPage
                .clickShippingContinueBtn();
        checkoutPaymentPage
                .selectPayByCheckRadioBtn()
                .acceptTermsOfService()
                .clickPlaceOrderBtn();
        String orderReference =
                orderConfirmationDetailsPage
                        .getOrderReference();
        headerPage
                .goToUserAccount();
        customerAccountPage
                .goToOrdersHistoryAndDetails();
        accountOrdersPage
                .goToOrderDetailsByOrderId(orderReference);

        assertThat(accountOrderDetailsPage.getOrderDate()).isEqualTo(sdf.format(date));
        assertThat(accountOrderDetailsPage.getTotalOrderPrice()).isEqualTo(29.00);
        assertThat(accountOrderDetailsPage.getPaymentMethodStatus()).isEqualTo("Awaiting check payment");
        assertThat(accountOrderDetailsPage.getDeliveryAddress()).isEqualTo(accountOrderDetailsPage
                .getFormattedAddress(address));
        assertThat(accountOrderDetailsPage.getInvoiceAddress()).isEqualTo(accountOrderDetailsPage
                .getFormattedAddress(invoiceAddress));
    }
}