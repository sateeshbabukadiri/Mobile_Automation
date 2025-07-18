package pages;

import utilities.BaseObjects;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.MalformedURLException;


public class ChooseCustomerScreen extends BaseObjects {


//    ChooseCustomerScreen page

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='ca.bell.selfserve.mybellmobile:id/logoImageView']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Bell'")

    public WebElement bellLogo;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='ca.bell.selfserve.mybellmobile:id/bannerImageView']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'BannerImage'")
    public WebElement bannerImage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='ca.bell.selfserve.mybellmobile:id/titleTextView']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Manage my privacy settings'")
    public WebElement titleText;

    public ChooseCustomerScreen() throws MalformedURLException {
    }

    public boolean isBellLogoDisplayed() {
        waitForElementVisible(bellLogo);
        return bellLogo.isDisplayed();
    }

    public void titleText() {
        waitForElementVisible(titleText);
        titleText.getText();
    }

}

