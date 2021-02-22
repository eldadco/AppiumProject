package Pages.MePage.Login;

import Pages.BasePage;

import java.net.MalformedURLException;

public class LoginVerifications extends BasePage {

    public LoginVerifications() throws MalformedURLException {
    }

    public boolean verifyTheEmailErrorLabelDisplayed() {
        return this.appiumInfra.isElementExists(LoginPageLocators.emailErrorLabel, null);

    }

    public boolean verifyThePasswordErrorLabelDisplayed() {
        return this.appiumInfra.isElementExists(LoginPageLocators.passwordErrorLabel, null);

    }



}
