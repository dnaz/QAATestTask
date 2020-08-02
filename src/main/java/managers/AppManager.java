package managers;

import helpers.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AppManager {
    private UserHelper userHelper;
    private NavigationHelper navigationHelper;
    private ItemHelper itemHelper;
    private CheckoutHelper checkoutHelper;

    private static WebDriver driver;

    AppManager() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions().addArguments("--incognito")
                .addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        userHelper = new UserHelper();
        navigationHelper = new NavigationHelper();
        itemHelper = new ItemHelper();
        checkoutHelper = new CheckoutHelper();

    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ItemHelper getItemHelper() {
        return itemHelper;
    }

    public CheckoutHelper getCheckoutHelper() {
        return checkoutHelper;
    }
}
