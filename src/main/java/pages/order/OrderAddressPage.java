package pages.order;

import models.Address;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class OrderAddressPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(OrderAddressPage.class);

    @FindBy(css = "[name=firstname]")
    private WebElement firstName;

    @FindBy(css = "[name=lastname]")
    private WebElement lastName;

    @FindBy(css = "[name=address1]")
    private WebElement address;

    @FindBy(css = "[name=city]")
    private WebElement city;

    @FindBy(css = "[name=id_state]")
    private WebElement stateSelect;

    @FindBy(css = "[name=postcode]")
    private WebElement zipPostalCode;

    @FindBy(css = "[name=id_country]")
    private WebElement countrySelect;

    @FindBy(css = "[name=confirm-addresses]")
    private WebElement addressContinueBtn;


    public OrderAddressPage(WebDriver driver) {
        super(driver);
    }

    public OrderAddressPage clickContinueBtn() {
        click(addressContinueBtn);
        return this;
    }

    public OrderAddressPage fillFirstName(String firstName) {
        sendKeysWithClear(this.firstName, firstName);
        return this;
    }

    public OrderAddressPage fillLastName(String lastName) {
        sendKeysWithClear(this.lastName, lastName);
        return this;
    }

    public OrderAddressPage fillAddress(String address) {
        sendKeysWithClear(this.address, address);
        return this;
    }

    public OrderAddressPage fillCity(String city) {
        sendKeysWithClear(this.city, city);
        return this;
    }

    public OrderAddressPage selectState(String state) {
        selectByValue(stateSelect, state);
        Select select = new Select(countrySelect);
        select.selectByVisibleText(state);
        return this;
    }

    public OrderAddressPage fillZipPostalCode(String zipPostalCodee) {
        sendKeysWithClear(zipPostalCode, zipPostalCodee);
        return this;
    }

    public OrderAddressPage selectCountry(String country) {
        Select countrySelect = new Select(this.countrySelect);
        countrySelect.selectByVisibleText(country);
        return this;
    }

    public OrderAddressPage fillInvoiceAddressForm(Address address) {
        waitToBeVisible(this.firstName);
        fillFirstName(address.getFirstName());
        fillLastName(address.getLastName());
        fillAddress(address.getAddress());
        fillZipPostalCode(address.getZipPostalCode());
        fillCity(address.getCity());
        selectCountry(address.getCountry());
        return this;
    }
}