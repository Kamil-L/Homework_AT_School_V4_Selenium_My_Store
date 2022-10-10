package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.products.grid.ProductGridMiniaturePage;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {

    private static final Logger log = LoggerFactory.getLogger(BasePage.class);


    public WebDriver driver;
    public Actions actions;
    public WebDriverWait wait;


    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("webelementTimeout"))));
    }

    public void click(WebElement element) {
        waitToBeClickable(element);
        log.info("<<<<< Clicking on: " + element.getText() + " >>>>>");
        element.click();
    }

    public void click(ProductGridMiniaturePage miniatureElement) {
        click(miniatureElement);
    }

    public void sendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("<<<<< Typing: " + text + " >>>>>");
        element.sendKeys(text);
    }

    public void sendKeysWithClear(WebElement element, String text) {
        element.clear();
        if (element.getText().length() != 0) {
            element.sendKeys(Keys.ALT + "a" + Keys.DELETE);
        }
        sendKeys(element, text);
        log.info("<<<<< Typing: " + text + " >>>>>");
    }

    public void moveToElement(WebElement element) {
        actions.moveToElement(element).perform();
        log.info("<<<<< Move to element: " + element.getText() + " >>>>>");

    }

    public void moveToElementWithoutPerform(WebElement element) {
        actions.moveToElement(element);
        log.info("<<<<< Move to element: " + element.getText() + " without perform >>>>>");
    }

    public void waitToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.info("<<<<< Wait for element: " + element.getText() + " to be clickable >>>>>");
    }

    public void waitToBeClickable(List<WebElement> elements) {
        wait.until(ExpectedConditions.elementToBeClickable((By) elements));
        log.info("<<<<< Wait for list of elements: " + elements + " to be clickable >>>>>");
    }

    public void waitToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("<<<<< Wait for element: " + element.getText() + " to be visible >>>>>");
    }

    public void waitToBeVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForVisibilityOfAllElements(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        log.info("<<<<< Wait for list of all elements: " + elements + " to be visible >>>>>");
    }

    public void waitToBeInvisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
        log.info("<<<<< Wait for element: " + element.getText() + " to be invisible >>>>>");
    }

    public void waitForUrlToBe(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
        log.info("<<<<< Wait for url: " + url + " to be >>>>>");
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        Random random = new Random();
        int randomIndexOfList = random.nextInt(elements.size());
        return elements.get(randomIndexOfList);
    }

    public String getRandomItem(List<String> items) {
        Random random = new Random();
        int randomIndexOfList = random.nextInt(items.size());
        return items.get(randomIndexOfList);
    }

    public void selectByValue(WebElement element, String value) {
        log.info("<<<<< Selecting option:" + value + " >>>>>");
        new Select(element).selectByValue(value);
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDisplayed(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void takeScreenshot() throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//src/main/resources/screenshot/screen.png"));
    }
}