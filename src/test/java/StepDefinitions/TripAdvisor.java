package StepDefinitions;


import Pages.TripAdvisorPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;


import java.net.MalformedURLException;

import static Utilities.BaseObjects.logMessage;

public class TripAdvisor {

    private static final Logger log = LogManager.getLogger(TripAdvisor.class);

    public TripAdvisor() throws MalformedURLException {
        super();
    }

    TripAdvisorPage tripAdvisorPage = new TripAdvisorPage();


    @Given("I click on Cancel button if google popup appears")
    public void iClickOnGoogleCancelButton() {
        if (tripAdvisorPage.isGoogleLogoDisplayed()) {
            tripAdvisorPage.tapGoogleCancelButton();
            logMessage("PASS", "Closed the Google popup");
        } else {
            log.info("Google Page is not displayed");
        }
    }

    @And("I verify Login and plan your next adventure popup")
    public void iVerifyLoginAndPlanYourNextAdventurePopup() {
        Assert.assertEquals(tripAdvisorPage.createAccountButton(), "Create account");
        Assert.assertEquals(tripAdvisorPage.continueWithGoogle(), "Continue with Google");
        if (tripAdvisorPage.loginAndPlanText().equalsIgnoreCase("Log in and plan your next adventure")) {
            Assert.assertEquals(tripAdvisorPage.loginAndPlanText(), "Log in and plan your next adventure");
            iCloseThePopup();
        } else {
            Assert.assertEquals(tripAdvisorPage.loginAndPlanText(), "Plan your best trips");
            tripAdvisorPage.tapSkipButton();
            logMessage("PASS", "tapped on Skip Button");
        }
    }

    @Then("I close the Login and plan your next adventure popup")
    public void iCloseThePopup() {
        tripAdvisorPage.tapXButton();
        logMessage("PASS", "Closed the Login and plan popup");
    }

    @And ("I verify Push Notification page")
    public void iVerifyPushNotificationPage(){
        tripAdvisorPage.isNotificationImageDisplayed();
        Assert.assertEquals(tripAdvisorPage.pushNotificationTitle.getText(),"Get personalised recommendations and updates for every part of your trip.");
        Assert.assertEquals(tripAdvisorPage.allowNotificationButtonText(),"Allow notifications");
    }

    @And ("I tap on May be later button on Push Notification page")
    public void iTapOnMaybeLaterButton(){
       tripAdvisorPage.tapMayBeLaterButton();
    }

}
