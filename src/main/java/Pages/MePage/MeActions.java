package Pages.MePage;

import Pages.BasePage;
import Pages.HomePage.HomePageLocators;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class MeActions extends BasePage {

    public MeActions() throws MalformedURLException {
    }

    public void openLoginOrRegisterPage() throws InterruptedException {

        Thread.sleep(3000);
        this.appiumInfra.clickElement(MeLocators.loginOrRegisterButton, null, null);
        this.appiumInfra.waitUntilVisibilityOfElement(MeLocators.loginButton);
    }

    public void openLoginTab() {
        if (!this.appiumInfra.getElementAttributeValue(null, "selected", MeLocators.loginButton, null)) {

            this.appiumInfra.clickElement(MeLocators.loginButton, null, null);
        }
    }
}
