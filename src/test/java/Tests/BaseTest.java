package Tests;

import XmlUtills.Inputs.InputsData;
import Pages.DriverUtills.DriverSingleton;
import DriverUtills.AppiumInfrastructure;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.HashMap;

public abstract class BaseTest {

    protected final AppiumInfrastructure appiumInfra = DriverSingleton.getInstance().appiumInfra;
    public static int testId = 1;
    InputsData inputsData = new InputsData();
    protected int numOfTests = inputsData.getNumOfTests();
    protected HashMap inputs;


    protected BaseTest() throws MalformedURLException {
    }


    @BeforeClass
    public void beforeClassMethod() {
        this.inputs = inputsData.getDataByTestId(testId);

    }


    @BeforeMethod
    public void beforeMethod() {
        this.inputs = inputsData.getDataByTestId(testId);
    }

    @AfterMethod
    public void afterTestActions() {
        testId++;

    }

    @AfterSuite
    public void afterSuiteMethod() {
        this.appiumInfra.close();
        this.appiumInfra.quit();
    }

}
