package Utilities;

import com.fasterxml.jackson.databind.JsonNode;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AppDriver {

    //    Stores a separate AppiumDriver instance per thread (useful for parallel test execution). Prevents session collisions.
    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    //    Implements the singleton pattern — ensures there's only one instance of AppDriver class used globally.
    private static final AppDriver instance = new AppDriver();
    //    Initializes a logger specific to this class for consistent logging.
    private static final Logger logger = Logger.getLogger(AppDriver.class.getName());

    //    Prevents other classes from instantiating AppDriver directly.
    private AppDriver() {
        // Private constructor to enforce singleton pattern
    }

    //    Provides global access to the single AppDriver instance.
    public static AppDriver getInstance() {
        return instance;
    }

    //    Gets the current thread-local driver instance.
    public AppiumDriver getDriver() {
        return driver.get();
    }

    //    Provides static access to the current driver from anywhere.
    public static AppiumDriver getCurrentDriver() {
        return getInstance().getDriver();
    }

    //    Sets the thread-local driver, useful when launching the app.
    public static void setDriver(AppiumDriver driverInstance) {
        driver.set(driverInstance);
        logger.info("Driver is set");
    }

    //    Main method to launch your app on Android or iOS.
    public static void launchApp(String platformName, String remoteHost) throws IOException {
//    Loads platform-specific capabilities from a JSON file using a helper method.
        DesiredCapabilities capabilities = getCapabilities(platformName);
//     Local reference to hold the new driver instance.
        AppiumDriver driver;

        try {
            if (platformName.equalsIgnoreCase("Android")) {
                driver = new AndroidDriver(new URL(remoteHost), capabilities);
            } else if (platformName.equalsIgnoreCase("iOS")) {
                driver = new IOSDriver(new URL(remoteHost), capabilities);
            } else {
                throw new RuntimeException("Unsupported platform: " + platformName);
            }

            setDriver(driver);
            getCurrentDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            logger.info("App launched on " + platformName);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to launch app on " + platformName, e);
            throw e;
        }
    }


    private static DesiredCapabilities getCapabilities(String platformName) {
        JsonNode platformNode = JSONFileReader.getPlatformNode(Constants.CAP_PATH, platformName);
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", platformNode.path("platformName").asText());
        capabilities.setCapability("appium:deviceName", platformNode.path("deviceName").asText());
        capabilities.setCapability("appium:automationName", platformNode.path("automationName").asText());
        capabilities.setCapability("appium:platformVersion", platformNode.path("platformVersion").asText());
        capabilities.setCapability("appium:noReset", platformNode.path("noReset").asText());

        // Set capabilities based on platform
        if (platformName.equalsIgnoreCase("Android")) {
            if (!platformNode.path("appActivity").asText().isEmpty()) {
                capabilities.setCapability("appium:appActivity", platformNode.path("appActivity").asText());
                capabilities.setCapability("appium:appPackage", platformNode.path("appPackage").asText());
            }
        } else if (platformName.equalsIgnoreCase("iOS")) {
            capabilities.setCapability("appium:bundleId", platformNode.path("bundleId").asText());
            capabilities.setCapability("appium:udid", platformNode.path("udid").asText());
        }

        return capabilities;
    }


    public static void quitDriver() {
        if (getCurrentDriver() != null) {
            getCurrentDriver().quit();
            driver.remove();
            logger.info("Driver quit and removed from ThreadLocal");
        }
    }
    }

