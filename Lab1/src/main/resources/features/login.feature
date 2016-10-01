Feature: PC Feature

  @1
  Scenario: Correct login
    Given I open habrahabr
    Given I select login
    Given I input "minchuk94@gmail.com" login
    Given I input "318114275pac" password
    When I submit login
    Then I should see success "MinchukSergei"

  @2
  Scenario: Logout
    Given I open context menu
    When I click logout
    Then I should see the login button

  @3
  Scenario: Incorrect login
    Given I open habrahabr
    Given I select login
    Given I input "min94@gmail.com" login
    Given I input "14428" password
    When I submit login
    Then I should see error "Пользователь с такой электронной почтой или паролем не найден"