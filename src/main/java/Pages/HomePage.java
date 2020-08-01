package Pages;

import Managers.PageManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Page {
    public HomePage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = "//p/a[contains(@class, 'user-link')]")
    private WebElement userLoginLinkLocator;

    @FindBy(xpath = "//*[@id='auth_email']")
    private WebElement loginInputFieldLocator;

    @FindBy(xpath = "//*[@id='auth_pass']")
    private WebElement passwordInputFieldLocator;

    @FindBy(xpath = "//button[contains(@class, 'auth-modal__submit')]")
    private WebElement logInButtonLocator;

    @FindBy(xpath = "//sidebar-fat-menu/div/ul/li[2]/a")
    private WebElement smartphoneCategoryLocator;

    @FindBy(xpath = "//rz-list-tile/div/a[contains(@href,'phones')][2]")
    private WebElement smartphoneSubCategoryLocator;

    @Step("Show the login form")
    public void showLoginForm() {
        wait.until(ExpectedConditions.visibilityOf(userLoginLinkLocator));
        userLoginLinkLocator.click();
    }

    @Step("Login as {0}")
    public void loginInput(String text) {
        wait.until(ExpectedConditions.visibilityOf(loginInputFieldLocator));
        loginInputFieldLocator.clear();
        loginInputFieldLocator.sendKeys(text);
    }

    @Step("Entered password {0}")
    public void passwordInput(String text) {
        wait.until(ExpectedConditions.visibilityOf(passwordInputFieldLocator));
        passwordInputFieldLocator.clear();
        passwordInputFieldLocator.sendKeys(text);
    }

    @Step("Pressing the Submit button")
    public void loginSubmit() {
        wait.until(ExpectedConditions.visibilityOf(logInButtonLocator));
        logInButtonLocator.click();
    }

    @Step("Go to the Smartphones category")
    public void goToTheSmartphonesCategory() {
        wait.until(ExpectedConditions.visibilityOf(smartphoneCategoryLocator));
        actions.moveToElement(smartphoneCategoryLocator).click().build().perform();
    }

    @Step("Go to the Smartphones sub category")
    public void goToTheSmartphonesSubCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(smartphoneSubCategoryLocator));
        actions.moveToElement(smartphoneSubCategoryLocator).build().perform();
        smartphoneSubCategoryLocator.click();
    }

}
