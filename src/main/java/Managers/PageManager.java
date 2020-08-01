package Managers;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManager {
    public static WebDriver driver;
    public HomePage homePage;
    public ItemPage itemPage;
    public CheckoutPage checkoutPage;

    public PageManager(WebDriver webDriver) {
        driver = webDriver;
        homePage = initElements(new HomePage(this));
        itemPage = initElements(new ItemPage(this));
        checkoutPage = initElements(new CheckoutPage(this));
    }

    private <T extends Page> T initElements(T page) {
        PageFactory.initElements(driver, page);
        return page;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
