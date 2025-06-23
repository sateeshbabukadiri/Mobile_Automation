package StepDefinitions;

import Runners.TestRunner;
import Utilities.AppDriver;
import Utilities.AppiumServerManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class BaseStepDef {

    private static final Logger logger = LogManager.getLogger(BaseStepDef.class);

    @Before
    public void setUp(Scenario scenario) {
        String platformName = TestRunner.platformName;
        String localHost = TestRunner.localHost;
        try {
            AppiumServerManager.start();
            AppDriver.launchApp(platformName, localHost);
            logger.info("Initiated setup for scenario: " + scenario.getName());
            Allure.label("Scenario", scenario.getName());
            Allure.description("ID: " + scenario.getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        logger.info("Scenario: " + scenario.getName() + " completed. Tearing down...");

        if (scenario.isFailed()) {
            Allure.step("Scenario failed: " + scenario.getName());
        } else {
            Allure.step("Scenario passed: " + scenario.getName());
        }

        AppDriver.quitDriver();
        AppiumServerManager.stop();
    }
}