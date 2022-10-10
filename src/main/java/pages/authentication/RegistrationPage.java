package pages.authentication;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;



public class RegistrationPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(RegistrationPage.class);

    @FindBy(css = ".form-control[name=firstname]")
    private WebElement firstName;

    @FindBy(css = ".form-control[name=lastname]")
    private WebElement lastName;

    @FindBy(css = ".form-control[name=email]")
    private WebElement email;

    @FindBy(css = ".form-control[name=password]")
    private WebElement password;

    @FindBy(css = ".form-control[name=birthday]")
    private WebElement birthDate;

    @FindBy(css = "[name=customer_privacy]")
    private WebElement customerPrivacyCheckbox;

    @FindBy(css = "[name=psgdpr]")
    private WebElement termOfUseAcceptanceCheckbox;

    @FindBy(css = ".register-form .btn-primary")
    private WebElement saveButton;


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }


    public String setFirstName(String firstName) {
        sendKeysWithClear(this.firstName, firstName);
        return firstName;
    }

    public String setLastName(String lastName) {
        sendKeysWithClear(this.lastName, lastName);
        return lastName;
    }

    public String setEmail(String email) {
        sendKeysWithClear(this.email, email);
        return email;
    }

    public String setPassword(String password) {
        sendKeysWithClear(this.password, password);
        return password;
    }

    public String setBirthDate(String birthDate) {
        sendKeysWithClear(this.birthDate, birthDate);
        return birthDate;
    }

    public void clickCustomerPrivacyCheckbox() {
        if (!customerPrivacyCheckbox.isSelected()) {
            customerPrivacyCheckbox.click();
        }
    }

    public void clickTermOfUseAcceptanceCheckbox() {
        if (!termOfUseAcceptanceCheckbox.isSelected()) {
            termOfUseAcceptanceCheckbox.click();
        }
    }

    public void clickSubmitFormBtn() {
        saveButton.click();
    }

    public void registerUser(User user) {
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        setBirthDate(user.getBirthDate().formatted(birthDate));
        clickCustomerPrivacyCheckbox();
        clickTermOfUseAcceptanceCheckbox();
        clickSubmitFormBtn();
    }
}