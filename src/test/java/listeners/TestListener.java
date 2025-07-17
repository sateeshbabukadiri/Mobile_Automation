package listeners;

import Utilities.AppDriver;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    public static AppiumDriver driver;

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite finished: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed: " + result.getName());
        Allure.step("Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: " + result.getName());
        logger.error("Cause: ", result.getThrowable());
        Allure.step("Test failed: " + result.getName());

        driver = AppDriver.getCurrentDriver();
        if (driver != null) {
            saveScreenshot();
            savePageSource();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test skipped: " + result.getName());
        Allure.step("Test skipped: " + result.getName());
    }

    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] saveScreenshot() {
        return driver.getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page Source", type = "text/xml")
    public String savePageSource() {
        return driver.getPageSource();
    }
}