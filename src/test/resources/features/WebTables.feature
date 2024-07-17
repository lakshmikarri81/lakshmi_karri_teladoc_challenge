Feature: Web Tables Automation

  Scenario: Add a user and validate the user has been added to the table
    Given I am on the web tables page
    When I add a new user with the details
    Then the user should be added to the table

  Scenario: Delete user "novak" and verify deletion
    Given I am on the web tables page
    When I identify the user
    And I delete the user
    Then I verify the user is deleted