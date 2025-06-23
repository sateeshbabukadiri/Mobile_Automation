package StepDefinitions;

import Utilities.BaseObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import Pages.PrivacyNoticePage;

import java.net.MalformedURLException;



public class LoginSteps extends BaseObjects {


    PrivacyNoticePage privacyNoticePage = new PrivacyNoticePage();

    public LoginSteps() throws MalformedURLException {
    }

    @Given("the privacy notice screen is displayed")
    public void privacyNoticeScreenIsDisplayed() {
     privacyNoticePage.isPrivacyNoticeDisplayed();
     Assert.assertEquals(privacyNoticePage.privacyNoticeText.getText(),"\nPrivacy notice");
    }


    @Then ("I tap on accept button")
    public void tapOnAcceptButton(){
        privacyNoticePage.tapAcceptButton();
        logMessage("pass","tapped on Accept Button");
    }

}
