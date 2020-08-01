import Utils.CustomerTestListener;
import Utils.PropertyLoader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomerTestListener.class)
public class BuyRandomItemTest extends BaseTest {

    String itemName;
    String contactSurname =  "Тестовий";

    @Test()
    @Description("Add a random item in the cart by logged user and complete the checkout form")
    public void buyRandomItemTest()  {
        app.getUserHelper().loginAs(PropertyLoader.loadProperty("rozetka.login"),
                PropertyLoader.loadProperty("rozetka.pass"));
        app.getNavigationHelper().goToRozetkaPage();
        app.getNavigationHelper().openSmartphonesCategory();
        app.getNavigationHelper().openItemPage();
        itemName = app.getItemHelper().getItemName();
        app.getItemHelper().addToCart();
        app.getItemHelper().openCartPopup();
        Assert.assertEquals(itemName, app.getItemHelper().getCartItemName());
        app.getNavigationHelper().openCheckoutPage();
        app.getCheckoutHelper().enterContactData(contactSurname,"Акаунт",
                "0963251452","Одеса");
        Assert.assertEquals(itemName, app.getCheckoutHelper().getItemName());
        app.getCheckoutHelper().chooseDeliveryAddress();
        app.getCheckoutHelper().choosePaymentOption();
        app.getCheckoutHelper().enterRecipientData("дядя","Вася","Петрович",
                "0633216548");
        app.getCheckoutHelper().chooseNotToCall();
    }
}
