package Helpers;

import Managers.AppManager;
import Managers.PageManager;
import io.qameta.allure.Step;

public class ItemHelper extends PageManager {
    public ItemHelper() {
        super(AppManager.getWebDriver());
    }

    @Step("Add an item to the cart")
    public void addToCart() {
        itemPage.addToCart();
    }

    @Step("Get the item's name")
    public String getItemName() {
        return itemPage.getItemName();
    }

    @Step("Open the cart popup")
    public void openCartPopup() {
        itemPage.openCartPopup();
    }

    @Step("Get the cart item name")
    public String getCartItemName() {
        return itemPage.getCartItemName();
    }
}
