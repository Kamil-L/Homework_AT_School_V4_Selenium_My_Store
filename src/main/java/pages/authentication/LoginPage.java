package pages.authentication;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class LoginPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(css = ".form-control[name=email]")
    private WebElement email;

    @FindBy(css = ".form-control[name=password]")
    private WebElement password;

    @FindBy(css = "#submit-login")
    private WebElement signInButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String fillEmail(String email) {
        sendKeysWithClear(this.email, email);
        return email;
    }

    public String fillPassword(String password) {
        sendKeysWithClear(this.password, password);
        return password;
    }

    public void clickSignInButton() {
        click(signInButton);

    }

    public void logIn(User user) {
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
        clickSignInButton();
    }
}