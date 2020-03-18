Feature: END to END

  Background: giving parameters
    Given user is navigate to webPage

  @API
  Scenario: Post a post in API and verify
    Given user is authorized topost
    And user is logged in to the website "admin" "admin"
    When user sends a post request with body "<title>" "<content>" "<status>"
      | title    | content    | status |
      | My title | My content | draft  |
    Then the pos is created in UI with status "draft"