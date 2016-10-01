Feature: PC Feature

  @1
  Scenario: correct Search
    Given I open habrahabr
    Given I click search button
    Given I input "png" text
    When I submit search
    Then I should see result success "png"

  @2
  Scenario: incorrect Search
    Given I click search button
    Given I input "rtfdgji" text
    When I submit search
    Then I should see result "Сожалеем, поиск в топиках не дал результатов"

  @3
  Scenario: change Search type
    Given I click search button
    Given I input "png" text
    Given I submit search
    Given I open type menu
    Given I choose type dev
    When I push enter
    Then I should see result with "Разработка"