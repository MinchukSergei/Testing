Feature: PC Feature

  @1
  Scenario: Correct login
    Given I open habrahabr
    Given I select login
    Given I input "email" login
    Given I input "pass" password
    When I submit login
    Then I should see success "Login"

  @2
  Scenario: Logout
    Given I open context menu
    When I click logout
    Then I should see the login button

  @3
  Scenario: Incorrect login
    Given I open habrahabr
    Given I select login
    Given I input "FAILemail" login
    Given I input "FAILpass" password
    When I submit login
    Then I should see error "Пользователь с такой электронной почтой или паролем не найден"