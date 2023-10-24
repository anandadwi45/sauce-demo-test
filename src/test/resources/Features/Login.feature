Feature: Login
  Scenario: I want to login on sauce demo website
    Given I open browser
    And open sauce demo website
    Then user input a registered username "standard_user"
    And user input registered password "secret_sauce"
    Then user click login button
    Then user directed to home screen
