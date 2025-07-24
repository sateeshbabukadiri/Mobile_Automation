package runners;

import stepdefinitions.BaseStepDef;
import io.appium.java_client.AppiumDriver;
import io.cucumber.tagexpressions.TagExpressionParser;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.stream.Collectors;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        plugin = {
                "pretty",
                "html:test-output/cucumberReport/cucumber-reports.html",
                "json:test-output/cucumberReport/CucumberTestReport.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

    private static final Logger logger = LogManager.getLogger(BaseStepDef.class);

    protected static AppiumDriver driver;
    public static String platformName;
    public static String localHost;

    @Parameters({"tags", "platformName", "localHost"})
    @BeforeClass
    public void runCucumberTests(@Optional("@Task1") String tags,
                                 @Optional("Android") String platform,
                                 @Optional("http://127.0.0.1:4723") String host) {
        System.setProperty("cucumber.filter.tags", tags);
        logger.info("platform name is " + platform);
        logger.info("Host is " + host);
        platformName = platform;
        localHost = host;
    }

    @Override
    @DataProvider()
    public Object[][] scenarios() {
        Object[][] scenarios = super.scenarios();
        String dynamicTags = System.getProperty("cucumber.filter.tags");
        if(dynamicTags != null && !dynamicTags.isEmpty()){
            return (Arrays.stream(scenarios).filter(scenario ->
                    TagExpressionParser.parse(dynamicTags).evaluate(((PickleWrapper) scenario[0])
                            .getPickle().getTags())).collect(Collectors.toList())).toArray(new Object[0][0]);
        } else {
            return scenarios;
        }
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Closing Appium Driver");
        if (driver != null) {
            driver.quit();
        }
    }

}
