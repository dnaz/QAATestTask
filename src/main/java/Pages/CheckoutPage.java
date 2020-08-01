package Pages;

import Managers.PageManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends Page {
    public CheckoutPage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = "(//input[@formcontrolname='surname'])[1]")
    private WebElement contactSurnameLocator;

    @FindBy(xpath = "(//input[@formcontrolname='name'])[1]")
    private WebElement contactNameLocator;

    @FindBy(xpath = "(//input[@formcontrolname='phone'])[1]")
    private WebElement contactPhoneLocator;

    @FindBy(xpath = "//auto-complete/input")
    private WebElement contactCityFieldLocator;

    @FindBy(xpath = "//auto-complete/ul/li[2]")
    private WebElement contactCityLocator;

    @FindBy(xpath = "//figcaption/div")
    private WebElement orderItemNameLocator;

    @FindBy(xpath = "(//label[contains(@class, 'checkout-variant')])[3]")
    private WebElement deliveryTypeLocator;

    @FindBy(xpath = "(//button[contains(@class, 'dropdown')])[2]")
    private WebElement deliveryOptionLocator;

    @FindBy(xpath = "(//div[contains(@class, 'autocomplete')]/ul/li)[3]")
    private WebElement deliveryAddressLocator;

    @FindBy(xpath = "(//label[contains(@class, 'checkout-variant')])[13]")
    private WebElement paymentOptionLocator;

    @FindBy(xpath = "(//label[contains(@class, 'checkout-variant')])[16]")
    private WebElement recipientOptionLocator;

    @FindBy(xpath = "(//input[@formcontrolname='surname'])[2]")
    private WebElement recipientSurnameLocator;

    @FindBy(xpath = "(//input[@formcontrolname='name'])[2]")
    private WebElement recipientNameLocator;

    @FindBy(xpath = "//input[@formcontrolname='patronymic']")
    private WebElement recipientPatronymicLocator;

    @FindBy(xpath = "(//input[@formcontrolname='phone'])[2]")
    private WebElement recipientPhoneLocator;

    @FindBy(xpath = "//label[@for = 'dont_call_me']")
    private WebElement dontCallLocator;

    @Step("Enter contact surname")
    public void setContactSurname(String contactSurname) {
        wait.until(ExpectedConditions.visibilityOf(contactSurnameLocator));
        contactSurnameLocator.clear();
        contactSurnameLocator.sendKeys(contactSurname);
    }

    @Step("Enter contact name")
    public void setContactName(String contactName) {
        wait.until(ExpectedConditions.visibilityOf(contactNameLocator));
        contactNameLocator.clear();
        contactNameLocator.sendKeys(contactName);
    }

    @Step("Enter contact phone")
    public void setContactPhone(String contactPhone) {
        wait.until(ExpectedConditions.visibilityOf(contactPhoneLocator));
        contactPhoneLocator.clear();
        contactPhoneLocator.sendKeys(contactPhone);
    }

    @Step("Enter and choose contact city")
    public void setContactCity(String contactCity) {
        wait.until(ExpectedConditions.visibilityOf(contactCityFieldLocator));
        contactCityFieldLocator.clear();
        contactCityFieldLocator.sendKeys(contactCity);
        contactCityFieldLocator.click();
        wait.until(ExpectedConditions.visibilityOf(contactCityLocator));
        contactCityLocator.click();
    }

    @Step("Get item name")
    public String getItemName() {
        wait.until(ExpectedConditions.visibilityOf(orderItemNameLocator));
        return orderItemNameLocator.getText();
    }

    @Step("Choose delivery address")
    public void chooseDeliveryAddress() {
        wait.until(ExpectedConditions.visibilityOf(deliveryTypeLocator));
        deliveryTypeLocator.click();
        wait.until(ExpectedConditions.visibilityOf(deliveryOptionLocator));
        deliveryOptionLocator.click();
        wait.until(ExpectedConditions.visibilityOf(deliveryAddressLocator));
        deliveryAddressLocator.click();
    }

    @Step("Choose payment option")
    public void choosePaymentOption() {
        wait.until(ExpectedConditions.visibilityOf(paymentOptionLocator));
        paymentOptionLocator.click();
    }

    @Step("Choose recipient option")
    public void chooseRecipientOption() {
        wait.until(ExpectedConditions.visibilityOf(recipientOptionLocator));
        recipientOptionLocator.click();
    }

    @Step("Enter recipient surname")
    public void setRecipientSurname(String recipientSurname) {
        wait.until(ExpectedConditions.visibilityOf(recipientSurnameLocator));
        recipientSurnameLocator.clear();
        recipientSurnameLocator.sendKeys(recipientSurname);
    }

    @Step("Enter recipient name")
    public void setRecipientName(String recipientName) {
        wait.until(ExpectedConditions.visibilityOf(recipientNameLocator));
        recipientNameLocator.clear();
        recipientNameLocator.sendKeys(recipientName);
    }

    @Step("Enter recipient patronymic")
    public void setRecipientPatronymic(String recipientPatronymic) {
        wait.until(ExpectedConditions.visibilityOf(recipientPatronymicLocator));
        recipientPatronymicLocator.clear();
        recipientPatronymicLocator.sendKeys(recipientPatronymic);
    }

    @Step("Enter recipient phone")
    public void setRecipientPhone(String recipientPhone) {
        wait.until(ExpectedConditions.visibilityOf(contactPhoneLocator));
        contactPhoneLocator.clear();
        contactPhoneLocator.sendKeys(recipientPhone);
    }

    @Step("Choose not to call")
    public void chooseNotToCall() {
        wait.until(ExpectedConditions.visibilityOf(dontCallLocator));
        dontCallLocator.click();
    }
}