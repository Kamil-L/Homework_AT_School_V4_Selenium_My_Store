package base;

import org.junit.jupiter.api.BeforeEach;
import pages.FiltersPage;
import pages.authentication.LoginPage;
import pages.authentication.RegistrationPage;
import pages.home.HeaderPage;
import pages.home.HomePage;
import pages.order.OrderAddressPage;
import pages.order.account.AccountOrderDetailsPage;
import pages.order.account.AccountOrdersPage;
import pages.order.account.CustomerAccountPage;
import pages.order.basket.BasketPage;
import pages.order.basket.BasketSummaryPage;
import pages.order.checkout.CheckoutAddressesPage;
import pages.order.checkout.CheckoutPaymentPage;
import pages.order.checkout.CheckoutShippingMethodPage;
import pages.order.confirmation.OrderConfirmationDetailsPage;
import pages.order.confirmation.OrderConfirmationItemsListPage;
import pages.products.CategoryDetailsPage;
import pages.products.ProductDetailsPage;
import pages.products.ProductPopupCartPage;
import pages.products.grid.ProductsGridPage;
import steps.AuthenticationSteps;

public class Pages extends TestBase {

    public CheckoutAddressesPage checkoutAddressesPage;
    public CheckoutPaymentPage checkoutPaymentPage;
    public CheckoutShippingMethodPage checkoutShippingMethodPage;
    public BasketPage basketPage;
    public BasketSummaryPage basketSummaryPage;
    public AccountOrderDetailsPage accountOrderDetailsPage;
    public AccountOrdersPage accountOrdersPage;
    public HomePage homePage;
    public CustomerAccountPage customerAccountPage;
    public LoginPage loginPage;
    public RegistrationPage registrationPage;
    public HeaderPage headerPage;
    public ProductsGridPage productsGridPage;
    public CategoryDetailsPage categoryDetailsPage;
    public ProductPopupCartPage productPopupCartPage;
    public ProductDetailsPage productDetailsPage;
    public FiltersPage filtersPage;
    public AuthenticationSteps authenticationSteps;
    public OrderAddressPage orderAddressPage;
    public OrderConfirmationDetailsPage orderConfirmationDetailsPage;
    public OrderConfirmationItemsListPage orderConfirmationItemsListPage;

    @BeforeEach
    public void testSetup() {
        checkoutAddressesPage = new CheckoutAddressesPage(driver);
        checkoutPaymentPage = new CheckoutPaymentPage(driver);
        checkoutShippingMethodPage = new CheckoutShippingMethodPage(driver);
        basketPage = new BasketPage(driver);
        basketSummaryPage = new BasketSummaryPage(driver);
        accountOrderDetailsPage = new AccountOrderDetailsPage(driver);
        accountOrdersPage = new AccountOrdersPage(driver);
        customerAccountPage = new CustomerAccountPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        headerPage = new HeaderPage(driver);
        homePage = new HomePage(driver);
        productsGridPage = new ProductsGridPage(driver);
        categoryDetailsPage = new CategoryDetailsPage(driver);
        productPopupCartPage = new ProductPopupCartPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        filtersPage = new FiltersPage(driver);
        authenticationSteps = new AuthenticationSteps(driver);
        orderAddressPage = new OrderAddressPage(driver);
        orderConfirmationDetailsPage = new OrderConfirmationDetailsPage(driver);
        orderConfirmationItemsListPage = new OrderConfirmationItemsListPage(driver);
    }
}