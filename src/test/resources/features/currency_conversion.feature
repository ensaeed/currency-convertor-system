Feature: Currency conversion validation

  Scenario: Validate multiple currency conversions using API
    Given I have currency conversion test data
    When I request converted amounts from the exchange rate API
    Then the API converted amounts should be within tolerance


  Scenario: Open XE currency converter page
    Given I open the XE currency converter page
    Then the XE currency converter page should be displayed

  Scenario: Convert currency using XE UI
    Given I open the XE currency converter page
    When I convert 100 from USD to EUR using XE UI
    Then I should see a conversion result on XE UI