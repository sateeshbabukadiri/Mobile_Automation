Feature: settings Feature
  Test the options in settings

  Scenario: Verify to turn WiFi ON and OFF
    Given I turn WiFi OFF
    Then I turn WiFi ON

  Scenario: Verify to turn Bluetooth ON and OFF
    Given I turn Bluetooth ON
    Then I turn Bluetooth OFF