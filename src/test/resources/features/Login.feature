@US2 @SR3
Feature: User Login
  As a user I want to securely access my account so I can interact with the Planetarium in a secure environment

  @Positive
  Scenario: User can login with valid credentials
    Given the existing user is on the login page
    When  the user provides a valid login username
    And   the user provides a valid login password
    And   the user submits the login credentials
    Then  the user should be redirected to the home page

  @Negative
  Scenario Outline: User can not login with invalid credentials
    Given the existing user is on the login page
    When  the user provides username "<username>"
    And   the user provides password "<password>"
    And   the user submits the login credentials
    Then  the user should get a browser alert saying "Invalid credentials"
    And   the user should stay on the login page

    Examples:
      |username|password       |
      |        |Iamthenight1939|
      |Batman  |               |
      |Batman  |b0Ts           |
      |Robin   |Iamthenight1939|
      |Robin   |b0Ts           |

  @Positive
  Scenario: User can logout
    Given the user is logged in on the home page
    When  the user clicks the logout link
    Then  the user should be redirected from the home page to the login page
    And   the user should not have access to their planetarium data
