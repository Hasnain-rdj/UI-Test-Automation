Feature: User Sign Up

  Scenario: Successful Sign Up
    Given the user is on the sign up page
    When the user enters valid sign up details
    Then the user should be signed up successfully
