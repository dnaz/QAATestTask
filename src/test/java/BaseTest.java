import managers.AppManager;
import managers.SingletonAppManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    AppManager app = SingletonAppManager.getInstance().manager;
    WebDriver driver = AppManager.getWebDriver();

    @BeforeMethod
    @Step("Go to the main page")
    public void before() {
        app.getNavigationHelper().goToRozetkaPage();
    }

    @AfterMethod()
    @Step("Clear cookies")
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @AfterSuite()
    public void tearDown() {
        AppManager.getWebDriver().quit();
    }
}
