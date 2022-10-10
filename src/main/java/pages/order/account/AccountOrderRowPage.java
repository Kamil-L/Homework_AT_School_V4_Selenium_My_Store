package pages.order.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;


public class AccountOrderRowPage {

    public AccountOrderRowPage(WebElement orderRow) {
        PageFactory.initElements(new DefaultElementLocatorFactory(orderRow), this);
    }

    @FindBy(css = "tbody th")
    private WebElement orderReference;

    @FindBy(xpath = "td[1]")
    private WebElement date;

    @FindBy(xpath = "td[2]")
    private WebElement totalPrice;

    @FindBy(xpath = "td[3]")
    private WebElement paymentMethod;

    @FindBy(xpath = "td[4]")
    private WebElement paymentStatus;

    @FindBy(xpath = "//a[contains(text(),'Details')]")
    private WebElement orderDetails;


    public String getOrderReference() {
        return orderReference.getText();
    }

    public String getDate() {
        return date.getText();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public String getPaymentMethod() {
        return paymentMethod.getText();
    }

    public String getOrderDetails() {
        return orderDetails.getText();
    }

    public String getPaymentStatus() {
        return paymentStatus.getText();
    }
}