Feature: Test the Login functionality

  Scenario Outline: Verify that user login successful with valid data
    Given user is on login page
    When user enter <username> and <password>
    And user clicks on Login button
    Then user is navigate to the home page
    Examples:
      | username                |  | password     |
      | standard_user           |  | secret_sauce |
      | problem_user            |  | secret_sauce |
      | performance_glitch_user |  | secret_sauce |

  Scenario Outline: Verify that user can not login incase one of the fields is empty
    Given user is on login page
    When user enter <username> and <password>
    And user clicks on Login button
    Then the error message is displayed

    Examples:
      | username      |  | password     |
      | standard_user |  |              |
      |               |  | secret_sauce |

  Scenario Outline: Verify that user can not login incase one of the fields is wrong
    Given user is on login page
    When user enter <username> and <password>
    And user clicks on Login button
    Then the error message is displayed

    Examples:
      | username        |  | password        |
      | locked_out_user |  | secret_sauce    |
      | standard_user   |  | secret_sauce111 |

  Scenario Outline: Verify that user can not login incase all fields is empty
    Given user is on login page
    When user enter <username> and <password>
    And user clicks on Login button
    Then the error message is displayed

    Examples:
      | username |  | password |
      |          |  |          |