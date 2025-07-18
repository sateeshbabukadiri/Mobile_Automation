package pages;

import utilities.BaseObjects;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class TripAdvisorPage extends BaseObjects {

    //Google login Popup
    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.google.android.gms:id/header_icon']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'WELCOME'")
    public WebElement googleLogo;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Cancel']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Cancel'")
    public WebElement googleCancelButton;

//    Login and plan popUp
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.tripadvisor.tripadvisor:id/txtThirdPartyTitle']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == ''")
    public WebElement loginAndPlanText;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.tripadvisor.tripadvisor:id/btnCreateAccount']| //android.widget.Button[@resource-id='com.tripadvisor.tripadvisor:id/btnEmail']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == ''")
    public WebElement createAccountButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Continue with Google']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == ''")
    public WebElement continueWithGoogleButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.tripadvisor.tripadvisor:id/bdlBtnEmail']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == ''")
    public WebElement haveAnAccountButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.tripadvisor.tripadvisor:id/imgCircularBtnIcon']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Cancel'")
    public WebElement cancelButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.tripadvisor.tripadvisor:id/bdlBtnSkip']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Skip'")
    public WebElement skipButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.tripadvisor.tripadvisor:id/imgNotificationPin']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == ''")
    public WebElement notificationImage;

    @AndroidFindBy(id = "com.tripadvisor.tripadvisor:id/txtRequestNotificationTitle")
    @iOSXCUITFindBy(iOSNsPredicate = "name == ''")
    public WebElement pushNotificationTitle;

    @AndroidFindBy(id = "com.tripadvisor.tripadvisor:id/btnRequestNotificationPermission")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Skip'")
    public WebElement allowNotificationsButton;

    @AndroidFindBy(id = "com.tripadvisor.tripadvisor:id/bdlBtnNotNow")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'MayBeLater'")
    public WebElement mayBeLaterButton;


    public TripAdvisorPage() throws MalformedURLException {
        super();
    }

    public boolean isGoogleLogoDisplayed() {
        waitForElementVisible(googleLogo);
        return googleLogo.isDisplayed();
    }

    public void tapGoogleCancelButton() {
        waitForElementVisible(googleCancelButton);
        googleCancelButton.click();
    }

    public String loginAndPlanText() {
        waitForElementVisible(loginAndPlanText);
        return loginAndPlanText.getText();
    }

    public String createAccountButton() {
        waitForElementVisible(createAccountButton);
        return createAccountButton.getText();
    }

    public String continueWithGoogle() {
        waitForElementVisible(continueWithGoogleButton);
        return continueWithGoogleButton.getText();
    }

    public void tapXButton() {
        waitForElementVisible(cancelButton);
        cancelButton.click();
    }

    public void tapSkipButton() {
        waitForElementVisible(skipButton);
        skipButton.click();
    }

    public boolean isNotificationImageDisplayed() {
        waitForElementVisible(notificationImage);
        return notificationImage.isDisplayed();
    }


    public String allowNotificationButtonText() {
        waitForElementVisible(allowNotificationsButton);
        return allowNotificationsButton.getText();
    }

    public void tapMayBeLaterButton() {
        try {
            waitForElementVisible(mayBeLaterButton);
            if (mayBeLaterButton.isDisplayed()) {
                mayBeLaterButton.click();
                logMessage("PASS", "Tapped on 'Maybe Later' button");
            } else {
                logMessage("FAIL", "'Maybe Later' button is not visible");
            }
        } catch (Exception e) {
            logMessage("FAIL", "Exception occurred while tapping 'Maybe Later' button: " + e.getMessage());
        }
    }



}
