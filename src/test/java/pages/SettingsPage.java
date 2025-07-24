package pages;

import utilities.BaseObjects;

import java.net.MalformedURLException;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SettingsPage extends BaseObjects {

    public SettingsPage() throws MalformedURLException {
    }

    // iOS Settings screen locators
    @iOSXCUITFindBy(accessibility = "Wi-Fi")
    public WebElement wifiCell;

    @iOSXCUITFindBy(accessibility = "Bluetooth")
    public WebElement bluetoothCell;

    @iOSXCUITFindBy(accessibility = "Airplane Mode")
    public WebElement airplaneModeCell;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeSwitch' AND name == 'Airplane Mode'")
    public WebElement airplaneModeSwitch;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeSwitch' AND name == 'Wi-Fi'")
    public WebElement wifiSwitch;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeSwitch' AND name == 'Bluetooth'")
    public WebElement bluetoothSwitch;

    // Android Settings screen locators
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/title' and @text='Connections']")
    public WebElement networkAndInternetCell;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    public WebElement connectionsBackButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/title' and @text='Wi-Fi']")
    public WebElement wifiCellAndroid;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bluetooth']")
    public WebElement bluetoothCellAndroid;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Airplane mode']")
    public WebElement airplaneModeCellAndroid;

    @AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='android:id/switch_widget' and ../android.widget.TextView[@text='Airplane mode']]")
    public WebElement airplaneModeSwitchAndroid;

    @AndroidFindBy(xpath = "//android.widget.Switch[@content-desc='Wi-Fi']")
    public WebElement wifiSwitchAndroid;

    @AndroidFindBy(xpath = "//android.widget.Switch[@content-desc='Bluetooth']")
    public WebElement bluetoothSwitchAndroid;

    // Methods to interact with iOS Settings
    public void openWiFiSettings() {
        waitForElementVisible(wifiCell);
        wifiCell.click();
    }

    public void openBluetoothSettings() {
        waitForElementVisible(bluetoothCell);
        bluetoothCell.click();
    }

    public void toggleAirplaneMode() {
        waitForElementVisible(airplaneModeSwitch);
        airplaneModeSwitch.click();
    }

    public void toggleWiFi() {
        waitForElementVisible(wifiSwitch);
        wifiSwitch.click();
    }

    public void toggleBluetooth() {
        waitForElementVisible(bluetoothSwitch);
        bluetoothSwitch.click();
    }

    // State check methods for iOS
    @SuppressWarnings("deprecation")
    public boolean isWiFiOn() {
        waitForElementVisible(wifiSwitch);
        return "1".equals(wifiSwitch.getAttribute("value"));
    }

    @SuppressWarnings("deprecation")
    public boolean isBluetoothOn() {
        waitForElementVisible(bluetoothSwitch);
        return "1".equals(bluetoothSwitch.getAttribute("value"));
    }

    // Methods to interact with Android Settings
    public void openNetworkAndInternetSettings() {
        networkAndInternetCell.click();
        logMessage("PASS","Clicked on connections");
    }

    public void tapOnConnectionsBackButton() {
        connectionsBackButton.click();
        logMessage("PASS","Clicked on connections Back button");
    }



    public void openWiFiSettingsAndroid() {
        waitForElementVisible(wifiCellAndroid);
        wifiCellAndroid.click();
    }

    public void openBluetoothSettingsAndroid() {
        waitForElementVisible(bluetoothCellAndroid);
        bluetoothCellAndroid.click();
    }

    public void toggleAirplaneModeAndroid() {
        waitForElementVisible(airplaneModeSwitchAndroid);
        airplaneModeSwitchAndroid.click();
    }

    public void toggleWiFiAndroid() {
        waitForElementVisible(wifiSwitchAndroid);
        wifiSwitchAndroid.click();
    }

    public void toggleBluetoothAndroid() {
        waitForElementVisible(bluetoothSwitchAndroid);
        bluetoothSwitchAndroid.click();
    }

    // State check methods for Android
    @SuppressWarnings("deprecation")
    public boolean isWiFiOnAndroid() {
        waitForElementVisible(wifiSwitchAndroid);
        return "true".equals(wifiSwitchAndroid.getAttribute("checked"));
    }

    @SuppressWarnings("deprecation")
    public boolean isBluetoothOnAndroid() {
        waitForElementVisible(bluetoothSwitchAndroid);
        return "true".equals(bluetoothSwitchAndroid.getAttribute("checked"));
    }
}
