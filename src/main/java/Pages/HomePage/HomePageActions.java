package Pages.HomePage;

import Pages.BasePage;
import Pages.MePage.MeLocators;

import java.net.MalformedURLException;

public class HomePageActions extends BasePage {


    public HomePageActions() throws MalformedURLException {
    }


    public void navigateToMePage() {

        this.appiumInfra.waitUntilInvisibilityOfElement(HomePageLocators.startPage);
        if (this.appiumInfra.isElementExists(HomePageLocators.getStart,null)) {
            this.appiumInfra.clickElement(HomePageLocators.getStart, null, null);
        }

        if (this.appiumInfra.isElementExists(HomePageLocators.popupCloseButton,null)) {
            this.appiumInfra.clickElement(HomePageLocators.popupCloseButton, null, null);
        }

        this.appiumInfra.clickElement(HomePageLocators.mainNavMe, null, null);
        this.appiumInfra.waitUntilVisibilityOfElement(MeLocators.loginOrRegisterButton);

    }
}




