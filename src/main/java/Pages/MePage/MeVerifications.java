package Pages.MePage;

import Pages.BasePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.MalformedURLException;

public class MeVerifications extends BasePage {

    public MeVerifications() throws MalformedURLException {
    }

    public boolean isUserConnected(String userName) {
        WebElement connectedUser = this.appiumInfra.waitUntilVisibilityOfElement(MeLocators.connectedUser);
        return this.appiumInfra.getTextFromElement(null, connectedUser, null).contains(userName);

    }


}
