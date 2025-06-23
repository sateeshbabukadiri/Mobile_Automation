package Pages;

import Utilities.BaseObjects;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;


public class PrivacyNoticePage extends BaseObjects {


    //    privacyNotice page
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='ca.bell.selfserve.mybellmobile:id/banner_title']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'WELCOME'")
    public WebElement privacyNoticeText;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='ca.bell.selfserve.mybellmobile:id/btn_accept_cookies']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GET STARTED'")
    public WebElement acceptButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='ca.bell.selfserve.mybellmobile:id/cookies_setting']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Manage my privacy settings'")
    public WebElement manageMyPrivacySettingsLink;

    public PrivacyNoticePage() throws MalformedURLException {
        super();
    }

    public boolean isPrivacyNoticeDisplayed() {
        waitForElementVisible(privacyNoticeText);
        return privacyNoticeText.isDisplayed();
    }

    public void tapAcceptButton() {
        waitForElementVisible(acceptButton);
        acceptButton.click();
    }
    public void manageMyPrivacySettingsLink() {
        waitForElementVisible(manageMyPrivacySettingsLink);

    }

}
