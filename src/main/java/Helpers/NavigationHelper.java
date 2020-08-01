package Helpers;

import Managers.AppManager;
import Managers.PageManager;
import Utils.PropertyLoader;
import io.qameta.allure.Step;

public class NavigationHelper extends PageManager {

    public NavigationHelper() {
        super(AppManager.getWebDriver());
    }

    @Step("Navigate to the main page rozetka.com.ua/")
    public void goToRozetkaPage() {
        driver.navigate().to(PropertyLoader.loadProperty("rozetka.link"));
    }

    @Step("Open item's page")
    public void openItemPage() {
        itemPage.openItemPage();
    }

    @Step("Go to smartphone category")
    public void openSmartphonesCategory() {
        homePage.goToTheSmartphonesCategory();
        homePage.goToTheSmartphonesSubCategory();
    }

    @Step("Open the checkout page")
    public void openCheckoutPage() {
        itemPage.openCheckoutPage();
    }

}
