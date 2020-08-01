package Pages;

import Managers.PageManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ItemPage extends Page {
    public ItemPage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = "(//a[contains(@class,'goods-tile__heading')])[3]")
    private WebElement itemLocator;

    @FindBy(xpath = "//div[@class = 'product-trade']//button[contains(@class, 'buy')]")
    private WebElement buyButtonLocator;

    @FindBy(xpath = "//ul/li[contains(@class,'type_cart')]")
    private WebElement cartButtonLocator;

    @FindBy(xpath = "//h1[@class='product__title']")
    private WebElement itemNameLocator;

    @FindBy(xpath = "//a[@class = 'cart-product__title']")
    private WebElement cartItemLocator;

    @FindBy(xpath = "//a[contains(@class, 'cart-receipt')]")
    private WebElement submitOrderButtonLocator;

    @Step("Open item's page")
    public void openItemPage() {
        wait.until(ExpectedConditions.visibilityOf(itemLocator));
        actions.moveToElement(itemLocator).click().build().perform();
    }

    @Step("Add an item to the cart")
    public void addToCart() {
        wait.until(ExpectedConditions.visibilityOf(buyButtonLocator));
        actions.moveToElement(buyButtonLocator).click().build().perform();
    }

    @Step("Get the item's name")
    public String getItemName() {
        wait.until(ExpectedConditions.visibilityOf(itemNameLocator));
        return itemNameLocator.getText();
    }

    @Step("Open the cart popup")
    public void openCartPopup() {
        wait.until(ExpectedConditions.visibilityOf(cartButtonLocator));
        actions.moveToElement(cartButtonLocator).click().build().perform();
    }

    @Step("Get the item's name")
    public String getCartItemName() {
        wait.until(ExpectedConditions.stalenessOf(cartItemLocator));
        return cartItemLocator.getText();
    }

    @Step("Open the checkout page")
    public void openCheckoutPage() {
        wait.until(ExpectedConditions.elementToBeClickable(submitOrderButtonLocator));
        actions.moveToElement(submitOrderButtonLocator).click().build().perform();
    }
}
