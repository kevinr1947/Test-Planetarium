@US5 @SR2
Feature: Remove planets and moons from the planetarium
  As a user I want to remove planets and moons from the Planetarium so I can correct my findings

  Background:
    Given   the user is logged in on the home page

  @Positive
  Scenario: the user can delete a planet with valid name
    When    the user selects planet from the dropdown
    When    the user enters the valid planet name to be deleted
    When    the user clicks the delete button
    Then    the user should no longer see the deleted planet

  @Positive
  Scenario: the user can delete a moon with valid name
    When    the user selects moon from the dropdown
    When    the user enters the valid moon name to be deleted
    When    the user clicks the delete button
    Then    the user should no longer see the deleted moon

  @Positive @MR5
  Scenario: moons associated with deleted planet should be deleted
    When    the user selects planet from the dropdown
    When    the user enters the valid planet name to be deleted
    When    the user clicks the delete button
    Then    the user should no longer see the deleted planet
    And     the user should no longer see the associated moons

  @Negative
  Scenario: The user can not delete a planet with invalid name
    When    the user selects planet from the dropdown
    When    the user enters an invalid planet name to be deleted
    When    the user clicks the delete button
    Then    the user should get a browser alert saying "Invalid planet name"

  @Negative
  Scenario: The user can not delete a moon with invalid name
    When    the user selects moon from the dropdown
    When    the user enters an invalid moon name to be deleted
    When    the user clicks the delete button
    Then    the user should get a browser alert saying "Invalid moon name"

