Feature: PC Feature

  @1
  Scenario: redirect to sandbox
    Given I open habrahabr
    When I redirect to sandbox articles
    Then I want to be in "https://habrahabr.ru/sandbox/"

  @2
  Scenario: 2nd page
    When I click on the second page
    Then I want to be on the second page

  @3
  Scenario: disable checkbox
    Given I redirect to publications
    When I click on ckeckbox
    Then I want it disabled

  @4
  Scenario: check users
    When I redirect to users
    Then I want to see users list