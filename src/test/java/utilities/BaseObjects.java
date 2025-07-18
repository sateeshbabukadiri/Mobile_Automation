package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseObjects {

    protected AppiumDriver driver;
    protected static Logger log;
    protected static WebDriverWait wait;

    public BaseObjects() throws MalformedURLException {
        this.driver = AppDriver.getCurrentDriver();
        log = LogManager.getLogger(this.getClass());
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void sleep(long timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            log.error("Thread sleep was interrupted!", e);
        }
    }

    public void waitForElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElement(WebElement element, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean isElementDisplayed(WebElement element, String message) {
        try {
            boolean displayed = element.isDisplayed();
            logMessage("pass", message + " is displayed");
            return displayed;
        } catch (WebDriverException e) {
            logMessage("fail", message + " is not displayed");
            Assert.fail("Element not found: " + message);
            return false;
        }
    }

    public static boolean isElementEnabled(WebElement element, String message) {
        try {
            boolean enabled = element.isEnabled();
            logMessage("pass", message + " is enabled");
            return enabled;
        } catch (WebDriverException e) {
            logMessage("fail", message + " is not enabled");
            Assert.fail("Element not found: " + message);
            return false;
        }
    }

    public static boolean isElementSelected(WebElement element, String message) {
        try {
            boolean selected = element.isSelected();
            logMessage("pass", message + " is selected");
            return selected;
        } catch (WebDriverException e) {
            logMessage("fail", message + " is not selected");
            Assert.fail("Element not found: " + message);
            return false;
        }
    }

    public static void logMessage(String status, String message) {
        log.info("[" + status.toUpperCase() + "] " + message);
        Allure.step("[" + status.toUpperCase() + "] " + message);
        if (status.equalsIgnoreCase("fail") || status.equalsIgnoreCase("warn")) {
            captureScreenshot();
            getPageSource();
        }
    }

    public static void logMessage(String status, Throwable t) {
        String message = "[" + status.toUpperCase() + "] Exception: " + t.getMessage();
        log.error(message, t);
        Allure.step(message);
        if (status.equalsIgnoreCase("fail") || status.equalsIgnoreCase("warn")) {
            captureScreenshot();
            getPageSource();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    protected static byte[] captureScreenshot() {
        AppiumDriver currentDriver = AppDriver.getCurrentDriver();
        return ((TakesScreenshot) currentDriver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page Source", type = "text/plain")
    public static String getPageSource() {
        AppiumDriver currentDriver = AppDriver.getCurrentDriver();
        try {
            return currentDriver.getPageSource();
        } catch (Exception e) {
            log.warn("Failed to get page source: " + e.getMessage());
            return "Failed to capture page source.";
        }
    }


    public void SwipeUp(){

    }
}