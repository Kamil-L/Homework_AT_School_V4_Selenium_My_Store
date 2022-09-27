package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class TopMenuPage extends BasePage {

    public TopMenuPage(WebDriver driver) {
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

    @FindBy(css = "li#category-4")
    private WebElement men;

    @FindBy(css = "li#category-5")
    private WebElement women;

    @FindBy(css = "li#category-7")
    private WebElement stationery;

    @FindBy(css = "li#category-8")
    private WebElement homeAccessories;

    @FindBy(css = "a[data-depth='0']")
    private List<WebElement> mainCategoriesItems;

    @FindBy(css = "a[data-depth='0']")
    private WebElement mainCategoriesItem;

    @FindBy(css = "a[data-depth='1']")
    private List<WebElement> subCategoriesItems;

    @FindBy(id = "#top-menu")
    private WebElement topMenu;


    public List<WebElement> getListOfMainCategoryElements() {
        List<WebElement> listOfMainCategoryElements = mainCategoriesItems;
        for (WebElement mainCategory : listOfMainCategoryElements) {
            listOfMainCategoryElements.add(mainCategory);
        }
        return listOfMainCategoryElements;
    }

    public List<String> getListOfMainCategory() {
        List<String> listOfMainCategory = new ArrayList<>();
        List<WebElement> listOfMainCategoryElements = mainCategoriesItems;
        for (WebElement mainCategory : listOfMainCategoryElements) {
        String categoryName = mainCategory.getText();
        listOfMainCategory.add(categoryName);
        }
        return listOfMainCategory;
    }

    public List<WebElement> getListOfSubCategory() {
        List<WebElement> listOfSubCategory = new ArrayList<>();
        for (WebElement subCategory : listOfSubCategory) {
            if (subCategory.isDisplayed()) {
                subCategoriesItems.add(subCategory);
            }
        }
        return listOfSubCategory;
    }

    public WebElement getMainCategoryElement() {
        return mainCategoriesItem;
    }

    public WebElement getClothesCategory() {
        return clothes;
    }
    public void clickOnClothesCategory() {
        click(clothes);
    }

    public void clickOnAccessoriesCategory() {
        click(accessories);
    }

    public void clickOnArtCategory() {
        click(art);
    }

    public void clickSearchSubmitButton() {
        click(searchSubmitButton);
    }

    public String typeProductNameIntoSearchField(String text) {
        click(searchField);
        sendKeysWithClear(searchField, text);
        return text;
    }

    public WebElement getSearchResultDropdownList() {
        return searchResultDropdownList;
    }

    public List<String> getSearchResultDropdownItem() {
        List<String> productsNameSearchFromDropdownList = new ArrayList<>();
        for (int i = 0; i < searchResultDropdownItems.size(); i++) {
            waitForVisibilityOfAllElements(searchResultDropdownItems);
            WebElement myElement = searchResultDropdownItems.get(i);
            String textValue = myElement.getText();
            productsNameSearchFromDropdownList.add(textValue);
        }
        return productsNameSearchFromDropdownList;
    }
}