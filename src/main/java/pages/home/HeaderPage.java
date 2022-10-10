package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class HeaderPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(HeaderPage.class);

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchField;

    @FindBy(css = "#search_widget button")
    private WebElement searchSubmitButton;

    @FindBy(css = "ui-id-1")
    private WebElement searchResultDropdownList;

    @FindBy(css = "ul.ui-autocomplete li")
    private List<WebElement> searchResultDropdownItems;

    @FindBy(id = "category-3")
    private WebElement clothes;

    @FindBy(id = "category-6")
    private WebElement accessories;

    @FindBy(id = "category-9")
    private WebElement art;

    @FindBy(css = "a[data-depth='0']")
    private List<WebElement> mainCategoriesItems;

    @FindBy(css = "a[data-depth='0']")
    private WebElement mainCategoriesItem;

    @FindBy(css = ".header .cart-products-count")
    private WebElement cartProductsAmount;

    @FindBy(css = ".account")
    private WebElement userAccount;

    @FindBy(css = ".cart-preview .header")
    private WebElement basketPreviewBtn;

    @FindBy(css = ".user-info a")
    private WebElement signInButton;

    @FindBy(css = ".no-account a")
    private WebElement newUserRegistration;


    public HeaderPage goToSignIn() {
        click(signInButton);
        return this;
    }

    public HeaderPage goToRegistration() {
        click(newUserRegistration);
        return this;
    }

    public HeaderPage goToUserAccount() {
        click(userAccount);
        return this;
    }

    public HeaderPage goToBasket() {
        click(basketPreviewBtn);
        return this;
    }

    public String getUserAccountName() {
        return userAccount.getText();
    }

    public String getMainCategory() {
        return mainCategoriesItem.getText();
    }

    public void clickOnMainCategory(int i) {
        click(mainCategoriesItem);
    }

    public int mainCategoriesItemsSize() {
        return mainCategoriesItems.size();
    }

    public HeaderPage clickOnClothesCategory() {
        click(clothes);
        return this;
    }

    public HeaderPage clickOnAccessoriesCategory() {
        click(accessories);
        return this;
    }

    public HeaderPage clickOnArtCategory() {
        click(art);
        return this;
    }

    public HeaderPage clickSearchSubmitBtn() {
        click(searchSubmitButton);
        return this;
    }

    public String typeProductNameIntoSearchField(String text) {
        click(searchField);
        sendKeysWithClear(searchField, text);
        return text;
    }

    public List<String> getSearchResultDropdownItem() {
        List<String> productsNameSearchFromDropdownList = new ArrayList<>();
        for (int i = 0; i < searchResultDropdownItems.size(); i++) {
            String textValue = searchResultDropdownItems.get(i).getText();
            productsNameSearchFromDropdownList.add(textValue);
        }
        return productsNameSearchFromDropdownList;
    }

    public int getCartProductsAmount() {
        return Integer.parseInt(cartProductsAmount.getText().replaceAll("[^0-9?!]", ""));
    }
}