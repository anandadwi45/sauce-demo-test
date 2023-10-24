Feature: Logout
  Scenario: I want logout on sauce demo website
    Given user is logged in to homepage
    Then click burger menu icon
    Then click logout
    Then login page displayed
