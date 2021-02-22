package Pages.DriverUtills;

import DriverUtills.AppiumInfrastructure;

import java.net.MalformedURLException;

public class DriverSingleton {
    public AppiumInfrastructure appiumInfra;
    private static DriverSingleton instance = null;

    private DriverSingleton() throws MalformedURLException {
        this.appiumInfra = new AppiumInfrastructure();

    }

    public static DriverSingleton getInstance() throws MalformedURLException {
        if (instance == null)
            instance = new DriverSingleton();

        return instance;
    }


}
