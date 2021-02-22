package Pages.MePage.Login;

import Pages.BasePage;
import io.qameta.allure.Step;

import java.net.MalformedURLException;

public class LoginActions extends BasePage {
    public LoginActions() throws MalformedURLException {
    }

    public void login(String emailAddress, String password) {

        this.appiumInfra.write(LoginPageLocators.emailInput, null, null, emailAddress);
        this.appiumInfra.write(LoginPageLocators.passwordInput, null, null, password);
        this.appiumInfra.clickElement(LoginPageLocators.loginButton, null, null);

    }


}
