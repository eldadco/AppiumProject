package DriverUtills;

import XmlUtills.DesiredCapabilities.DesiredCapabilitiesReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AppiumInfrastructure {
    protected AndroidDriver driver;
    protected WebDriverWait waitForElems;
    protected JavascriptExecutor js;
    protected ExpectedConditions conditions;
    private static final Logger logger = LogManager.getLogger(AppiumInfrastructure.class);

    public AppiumInfrastructure() throws MalformedURLException {


        HashMap capabilities = new DesiredCapabilitiesReader().getInputsFromXml();

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", capabilities.get("deviceName"));
        desiredCapabilities.setCapability("platformName", capabilities.get("platformName"));
        desiredCapabilities.setCapability("platformVersion", capabilities.get("platformVersion"));
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appPackage", "com.zzkko");
        desiredCapabilities.setCapability("appActivity", "com.zzkko.bussiness.welcome.WelcomeActivity");
        URL remoteAddress = new URL("http://localhost:4723/wd/hub");

        this.driver = new AndroidDriver(remoteAddress, desiredCapabilities);

        this.waitForElems = new WebDriverWait(this.driver, 70);

    }

    public void write(By locator, WebElement element, WebElement fromElement, String data) {
        try {
            if (element == null) {
                element = this.findElement(locator, fromElement);
            }
            element.sendKeys(data);
            logger.info("Appium-infra success message: The data was insert successfully " + data);

        } catch (ElementNotInteractableException | ElementNotSelectableException exception) {
            logger.error("Appium-infra error : ", exception);
        }
    }


    public void clickElement(By locator, WebElement elem, WebElement fromElement) {
        try {
            if (elem == null) {
                this.waitUntilVisibilityOfElement(locator);
                elem = this.findElement(locator, fromElement);
            }
            elem.click();
            logger.info("Appium-infra success message:\tThe element " + locator + " was successfully clicked");

        } catch (ElementNotVisibleException | ElementNotSelectableException exception) {
            logger.error("Appium-infra error : ", exception);
        }
    }

    public boolean getElementAttributeValue(WebElement element, String attribute, By locator, WebElement fromElement) {
        if (element == null) {
            element = this.findElement(locator, fromElement);
        }
        return element.getAttribute(attribute).equals("true");

    }

    public WebElement findElement(By locator, WebElement fromElement) {
        try {
            if (fromElement == null) {
                return this.driver.findElement(locator);
            } else {
                return fromElement.findElement(locator);
            }

        } catch (InvalidSelectorException exception) {
            logger.error("Appium-infra error : " + "invalid selector exception by:" + locator, exception);
        } catch (
                NoSuchElementException exception) {
            logger.error("Appium-infra error : No such element exception  : " + locator, exception);

        } catch (
                ElementNotVisibleException exception) {
            logger.error("Appium-infra error : element not visible exception : " + locator);
        }
        return null;
    }

    public Boolean isElementExists(By locator, WebElement fromElement) {
        WebElement element = this.findElement(locator, fromElement);
        return element != null;
    }

    public WebElement waitUntilVisibilityOfElement(By locator) {
        WebElement result = this.waitForElems.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return result;
    }

    public void waitUntilInvisibilityOfElement(By locator) {
        Boolean result = this.waitForElems.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public String getTextFromElement(By locator, WebElement elem, WebElement fromElement) {
        try {
            if (elem == null) {
                elem = this.findElement(locator, fromElement);

            }
            return elem.getText();
        } catch (Exception exception) {
            logger.error("appiumInfra error: ", exception);
            return "getTextFromElement function failed";
        }
    }

    public void close() {

        this.driver.closeApp();
    }

    public void quit() {
        this.driver.quit();
    }
}
