package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DriverFactory {

    private static Logger log = LoggerFactory.getLogger(DriverFactory.class);
    private WebDriver driver;
    private String browserName;

    public WebDriver getDriver() {
        this.browserName = System.getProperty("browserName");
        log.info("BrowserName: " + browserName);
        switch (this.browserName) {
            case "chrome":
                getChromeDriver();
                break;
            case "firefox":
                getFirefoxDriver();
                break;
            case "ie":
                getInternetExplorerDriver();
                break;
            case "edge":
                getEdgeDriver();
                break;
            default:
                throw new IllegalStateException("Incorrect browser type! Please check your configuration");
        }
        return this.driver;
    }

    private void getChromeDriver() {
        ChromeOptions optionsChrome = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        optionsChrome.addArguments("start-maximized");
        driver = new ChromeDriver(optionsChrome);
    }

    private void getFirefoxDriver() {
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        optionsFirefox.addArguments("start-maximized");
        driver = new FirefoxDriver(optionsFirefox);
    }

    private void getInternetExplorerDriver() {
        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
    }

    private void getEdgeDriver() {
        EdgeOptions optionsEdge = new EdgeOptions();
        WebDriverManager.edgedriver().setup();
        optionsEdge.addArguments("start-maximized");
        driver = new EdgeDriver(optionsEdge);
    }
}