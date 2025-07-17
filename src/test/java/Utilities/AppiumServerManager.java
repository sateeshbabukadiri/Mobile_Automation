package utilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class AppiumServerManager {
    private static final Logger logger = LogManager.getLogger(AppiumServerManager.class);
    private static AppiumDriverLocalService server;

    private static void setInstance() {

        // Ensure the log directory exists
        File logDir = new File("testOutput");
        if (!logDir.exists()) {
            boolean created = logDir.mkdirs();
            if (created) {
                logger.info("Created log directory at: " + logDir.getAbsolutePath());
            } else {
                logger.warn("Failed to create log directory. Logs may not be saved.");
            }
        }

        // Build the AppiumServiceBuilder
        server = new AppiumServiceBuilder()
                .withAppiumJS(new File(appiumServerPath()))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withLogFile(new File(logDir, "AppiumLog.txt"))
                .withArgument(GeneralServerFlag.LOG_LEVEL, "error")
                .build();
    }

    private static AppiumDriverLocalService getInstance() {
        if (server == null) {
            setInstance();
        }
        return server;
    }

    public static void start() {
        getInstance().start();
        logger.info("Appium server started at URL: " + server.getUrl());
        logger.info("Is Appium server running? " + server.isRunning());
    }

    public static void stop() {
        if (server != null && server.isRunning()) {
            server.stop();
            logger.info("Appium server stopped.");
        } else {
            logger.warn("Appium server was not running.");
        }
    }

    private static String appiumServerPath() {
        String[] possiblePaths = {
                "/opt/homebrew/bin/appium", // Apple Silicon
                "/usr/local/bin/appium"      // Intel Macs
        };

        for (String path : possiblePaths) {
            if (new File(path).exists()) {
                logger.info("Appium server found at: " + path);
                return path;
            }
        }

        throw new RuntimeException("Appium server executable not found. Please ensure Appium is installed via NPM or Homebrew.");
    }
}