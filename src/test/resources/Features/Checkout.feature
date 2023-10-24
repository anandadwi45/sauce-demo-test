Feature: Checkout
  Scenario: I want checkout a product on sauce demo website
    Given user is logged in and select a product
    Then click add to cart
    Then click cart icon
    Then cart page displayed
    Then click checkout button
    Then input first name "Alpha"
    And input last name "Beta"
    And input postal code "10000"
    Then click continue
    Then checkout overview displayed
    Then click finish
    Then checkout complete displayed

  Scenario: I want to checkout a product without input personal information
    Given user is logged in and select a product
    Then click add to cart
    Then click cart icon
    Then cart page displayed
    Then click checkout button
    Then click continue
    Then error message displayed