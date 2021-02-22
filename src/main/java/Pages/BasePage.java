package Pages;

import Pages.DriverUtills.DriverSingleton;
import DriverUtills.AppiumInfrastructure;

import java.net.MalformedURLException;

abstract public class BasePage {
    protected AppiumInfrastructure appiumInfra = DriverSingleton.getInstance().appiumInfra;

    public BasePage() throws MalformedURLException {
    }

}
