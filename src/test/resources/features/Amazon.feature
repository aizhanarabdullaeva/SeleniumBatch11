Feature: Amazon search functionality

  Scenario: Positive scenario for Amazon search
    When I navigate to Amazon homepage
    And I search for iphone  case
    Then I should get more than 20 results
    And I validate search number