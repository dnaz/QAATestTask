package helpers;

import managers.AppManager;
import managers.PageManager;
import io.qameta.allure.Step;

public class CheckoutHelper extends PageManager {

    public CheckoutHelper() {
        super(AppManager.getWebDriver());
    }

    @Step("Enter contact data")
    public void enterContactData(String contactSurname, String contactName,String contactPhone,String contactCity) {
        checkoutPage.setContactSurname(contactSurname);
        checkoutPage.setContactName(contactName);
        checkoutPage.setContactPhone(contactPhone);
        checkoutPage.setContactCity(contactCity);
    }

    @Step("Get item name")
    public String getItemName() {
        return checkoutPage.getItemName();
    }

    @Step("Choose delivery address")
    public void chooseDeliveryAddress() {
        checkoutPage.chooseDeliveryAddress();
    }

    @Step("Choose payment option")
    public void choosePaymentOption() {
        checkoutPage.choosePaymentOption();
    }

    @Step("Enter recipient data")
    public void enterRecipientData(String recipientSurname, String recipientName, String recipientPatronymic,
                                      String recipientPhone) {
//        checkoutPage.chooseRecipientOption();
        checkoutPage.setRecipientSurname(recipientSurname);
        checkoutPage.setRecipientName(recipientName);
        checkoutPage.setRecipientPatronymic(recipientPatronymic);
        checkoutPage.setRecipientPhone(recipientPhone);
    }

    @Step("Choose not to call")
    public void chooseNotToCall() {
        checkoutPage.chooseNotToCall();
    }


}
