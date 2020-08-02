package helpers;

import managers.AppManager;
import managers.PageManager;
import io.qameta.allure.Step;

public class UserHelper extends PageManager {
    public UserHelper() {
        super(AppManager.getWebDriver());
    }

    @Step("Log in as {0} with the password {1}")
    public void loginAs(String login, String pass) {
        homePage.showLoginForm();
        homePage.loginInput(login);
        homePage.passwordInput(pass);
        homePage.loginSubmit();
    }
}