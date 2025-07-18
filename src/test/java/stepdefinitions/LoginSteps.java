package stepdefinitions;

import utilities.BaseObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.PrivacyNoticePage;

import java.net.MalformedURLException;



public class LoginSteps extends BaseObjects {


    PrivacyNoticePage privacyNoticePage = new PrivacyNoticePage();

    public LoginSteps() throws MalformedURLException {
    }

    @When("the privacy notice screen is displayed")
    public void privacyNoticeScreenIsDisplayed() {
     privacyNoticePage.isPrivacyNoticeDisplayed();
     Assert.assertEquals(privacyNoticePage.privacyNoticeText.getText(),"Privacy notice");
    }

    @Then ("I tap on accept button")
    public void tapOnAcceptButton(){
        privacyNoticePage.tapAcceptButton();
        logMessage("pass","tapped on Accept Button");
    }

    @When ("I verify the choose customer screen")
    public void verifyTheChooseCustomerScreen(){

    }

}
