package base;

import config.AppProperties;
import config.DriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {

    static Logger log = LoggerFactory.getLogger(TestBase.class);
    public static WebDriver driver;
    public static DriverFactory driverFactory;
    public static AppProperties appProperties;

    @BeforeAll
    static void setDriver() {
        appProperties = AppProperties.getInstance();
        driverFactory = new DriverFactory();
        log.info("<<<<< Driver opened browser >>>>>");
        driver = driverFactory.getDriver();
        log.info("<<<<< Driver initialized >>>>");
        driver.get(System.getProperty("appUrl"));
        log.info("<<<<< Driver opened " + System.getProperty("appUrl") + " >>>>>");
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
        log.debug("<<<<<Driver closed>>>>>");
    }
}