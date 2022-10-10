package steps;

import models.User;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import pages.authentication.LoginPage;
import pages.authentication.RegistrationPage;
import pages.home.HeaderPage;

public class AuthenticationSteps extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationSteps.class);

    public AuthenticationSteps(WebDriver driver) {
        super(driver);
    }

    HeaderPage headerPage = new HeaderPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);


    public void logInUser(User user) {
        headerPage
                .goToSignIn();
        loginPage
                .logIn(user);
    }

    public void newUserRegistration(User user) {
        headerPage
                .goToSignIn()
                .goToRegistration();
        registrationPage
                .registerUser(user);
    }
}