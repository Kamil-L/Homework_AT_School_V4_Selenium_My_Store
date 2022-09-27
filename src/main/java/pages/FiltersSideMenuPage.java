package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FiltersSideMenuPage extends BasePage {

    public FiltersSideMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "#search_filters")
    private WebElement searchFilters;

    @FindBy(css = ".ui-slider-handle:nth-of-type(1)")
    private WebElement leftPriceSliderHandler;

    @FindBy(css = ".ui-slider-handle:nth-of-type(2)")
    private WebElement rightPriceSliderHandler;

    @FindBy(xpath = "//li/p")
    private WebElement currentPriceRangeFilter;

    @FindBy(css = ".js-search-filters-clear-all")
    private WebElement clearAllFiltersButton;

    @FindBy(css = ".close")
    private WebElement clearFilterButton;

    @FindBy(css = ".overlay__content")
    private WebElement coverage;


    public int setMaxPriceFilterValue(int max) {
        moveRightSliderHandler(max);
        return max;
    }

    public int setMinPriceFilterValue(int min) {
        moveLeftSliderHandler(min);
        return min;
    }

    public void setPriceFilterValues(int min, int max) {
        moveLeftSliderHandler(min);
        moveRightSliderHandler(max);
    }

    public void moveLeftSliderHandler(int min) {
        int moveValue = min - getMinLabelPrice();
        if (moveValue > 0) {
            for (int i = 0; i < moveValue; i++) {
                leftPriceSliderHandler.sendKeys(Keys.ARROW_RIGHT);
                waitToBeInvisible(coverage);
            }
        }
    }

    public void moveRightSliderHandler(int max) {
        int moveValue = getMaxLabelPrice() - max;
        if (moveValue > 0) {
            for (int i = 0; i < moveValue; i++) {
                rightPriceSliderHandler.sendKeys(Keys.ARROW_LEFT);
                waitToBeInvisible(coverage);
            }
        }
    }

    private String getFiltersPriceRange() {
        String priceFilterRange = currentPriceRangeFilter.getText();
        return priceFilterRange.replaceAll("\\$|\\.00", "");
    }

    private int getMinLabelPrice() {
        return Integer.parseInt(getFiltersPriceRange().substring(0,1));
    }

    private int getMaxLabelPrice() {
        return Integer.parseInt(getFiltersPriceRange().substring(4));
    }

    public boolean checkForSearchFiltersToBeDisplayed() {
        return isDisplayed(searchFilters);
    }

    public void clickClearAllFiltersButton() {
        if (isDisplayed(clearAllFiltersButton))
            click(clearAllFiltersButton);
    }

    public void clickClearFilterButton() {
        waitToBeVisible(clearFilterButton);
        click(clearFilterButton);
        waitToBeInvisible(coverage);
    }
}