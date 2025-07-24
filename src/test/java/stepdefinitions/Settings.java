package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import pages.SettingsPage;
import utilities.BaseObjects;

public class Settings extends BaseObjects {
    SettingsPage settingsPage;

    public Settings() throws Exception {
        settingsPage = new SettingsPage();
    }

    @And("^I turn WiFi ON$")
    public void turnWiFiOn() {
        if (isAndroid()) {
            settingsPage.openNetworkAndInternetSettings();
            if (!(settingsPage.isWiFiOnAndroid())) {
                settingsPage.toggleWiFiAndroid();
                log.info("Turned ON the WIFI");
            }else{
                log.info("WIFI is already in ON state");
            }
            settingsPage.tapOnConnectionsBackButton();
        } else {
            settingsPage.openWiFiSettings();
            if (!settingsPage.isWiFiOn()) {
                settingsPage.toggleWiFi();
            }
        }
    }

    @And("^I turn WiFi OFF$")
    public void turnWiFiOff() {
        if (isAndroid()) {
            settingsPage.openNetworkAndInternetSettings();
            if (settingsPage.isWiFiOnAndroid()) {
                settingsPage.toggleWiFiAndroid();
            }else{
                log.info("WIFI is already in OFF state");
            }
            settingsPage.tapOnConnectionsBackButton();
        } else {
            settingsPage.openWiFiSettings();
            if (settingsPage.isWiFiOn()) {
                settingsPage.toggleWiFi();
            }
        }
    }

    @And("^I turn Bluetooth ON$")
    public void turnBluetoothOn() {
        if (isAndroid()) {
            settingsPage.openNetworkAndInternetSettings();
            if (!settingsPage.isBluetoothOnAndroid()) {
                settingsPage.toggleBluetoothAndroid();
            }else{
                log.info("Bluetooth is already in ON state");
            }
            settingsPage.tapOnConnectionsBackButton();

        } else {
            settingsPage.openBluetoothSettings();
            if (!settingsPage.isBluetoothOn()) {
                settingsPage.toggleBluetooth();
            }
        }
    }

    @And("^I turn Bluetooth OFF$")
    public void turnBluetoothOff() {
        if (isAndroid()) {
            settingsPage.openNetworkAndInternetSettings();
            if (settingsPage.isBluetoothOnAndroid()) {
                settingsPage.toggleBluetoothAndroid();
            }else{
                log.info("Bluetooth is already in OFF state");
            }
            settingsPage.tapOnConnectionsBackButton();
        } else {
            settingsPage.openBluetoothSettings();
            if (settingsPage.isBluetoothOn()) {
                settingsPage.toggleBluetooth();
            }
        }
    }

} 