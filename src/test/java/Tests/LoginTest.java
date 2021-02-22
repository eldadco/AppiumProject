package Tests;

import Pages.MePage.Login.LoginActions;
import Pages.MePage.Login.LoginVerifications;
import Pages.MePage.MeActions;
import Pages.MePage.MeVerifications;
import org.testng.Assert;
import org.testng.annotations.*;
import Pages.HomePage.*;

import java.net.MalformedURLException;
import java.util.HashMap;


public class LoginTest extends BaseTest {
    HomePageActions homePageActions;
    MeActions mePageActions;
    LoginActions loginActions;
    LoginVerifications loginVerifications;
    MeVerifications meVerifications;
    String emailAddress;
    String password;


    public LoginTest() throws MalformedURLException {
        this.homePageActions = new HomePageActions();
        this.mePageActions = new MeActions();
        this.loginActions = new LoginActions();
        this.meVerifications = new MeVerifications();
        this.loginVerifications = new LoginVerifications();
    }

    @BeforeMethod
    public void configData() {
        this.emailAddress = this.inputs.get("emailAddress").toString();
        this.password = this.inputs.get("password").toString();
    }

    @BeforeClass
    public void beforeClass() throws InterruptedException {
        this.homePageActions.navigateToMePage();
        this.mePageActions.openLoginOrRegisterPage();
        this.mePageActions.openLoginTab();
    }

    @Test(description = "Insert correct credentials and verify the login success")
    public void loginPositiveTest() throws InterruptedException {
        this.loginActions.login(this.emailAddress, this.password);
        Assert.assertTrue(this.meVerifications.isUserConnected(this.emailAddress.split("@")[0]), "Verify the user logged in successfully");
    }

}
