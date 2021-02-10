Feature: Webshop tests

  Scenario: Go to website
    Given I go to "http://automationpractice.com/index.php"
    When I search for dress
    And I click on the product card picture
    Then "Printed Dress" is shown

    Scenario: Add something to cart from FrontPage
      Given I go to "http://automationpractice.com/index.php"
      When I hover over product card 1
      And I add product to cart
      Then I check if "Blouse" is added at cart

    Scenario: Add something to cart from ResultPage
      Given I go to "http://automationpractice.com/index.php"
      When I search for dress
      And I hover over product card 6
      And I add product to cart
      Then I check if "Blouse" is added at cart