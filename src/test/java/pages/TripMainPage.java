package pages;

import utilities.BaseObjects;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class TripMainPage extends BaseObjects {

    public TripMainPage() throws MalformedURLException {
        super();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.tripadvisor.tripadvisor:id/navigation_bar_item_large_label_view']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Home'")
    public WebElement homeTabText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.tripadvisor.tripadvisor:id/navigation_bar_item_small_label_view'and @text='Search']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Home'")
    public WebElement searchTabText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.tripadvisor.tripadvisor:id/navigation_bar_item_small_label_view' and @text='Trips']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Home'")
    public WebElement tripsTabText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.tripadvisor.tripadvisor:id/navigation_bar_item_small_label_view' and @text='Review']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Home'")
    public WebElement reviewTabText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.tripadvisor.tripadvisor:id/navigation_bar_item_small_label_view' and @text='Account']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Home'")
    public WebElement accountTabText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.tripadvisor.tripadvisor:id/txtTitle']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Home'")
    public WebElement mainPageTitleText;

    public String mainPageTitle() {
        waitForElementVisible(mainPageTitleText);
        return mainPageTitleText.getText();
    }

    public String homeTabText() {
        waitForElementVisible(homeTabText);
        return homeTabText.getText();
    }

    public String searchTabText() {
        return searchTabText.getText();
    }

    public String tripsTabText() {
        return tripsTabText.getText();
    }

    public String reviewTabText() {
        return reviewTabText.getText();
    }
    public String accountTabText() {
        return accountTabText.getText();
    }

}
