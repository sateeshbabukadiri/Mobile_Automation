Feature: preLoginStepsTripAdvisor
  Verify the Google Popup

  @Task1
  Scenario: Verify trip Advisor Login page
    Given I click on Cancel button if google popup appears
    And  I verify Login and plan your next adventure popup
    And I verify Push Notification page
    Then I tap on May be later button on Push Notification page

  @Task2
  Scenario: Verify trip Advisor Main Page
    Given I land on main page
    And I verify all tabs are visible