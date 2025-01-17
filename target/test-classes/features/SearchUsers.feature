Feature: 
  Search user test

  @smoke
  Scenario Outline: search with valid users
    Given user launches the application
    And user enters the credentials "<username>" "<password>"
    When user clicks login button
    And user clicks the admin button
    And user enters the username "<usernameToSearch>"
    When user clicks the search button
    Then record should appear
    And user should logout

    Examples: 
      | username | password | usernameToSearch |
      | Admin    | admin123 | Admin            |
      | Admin    | admin123 | Admin            |
      | Admin    | admin123 | Admin            |

  @smoke
  Scenario Outline: search with invalid users
    Given user launches the application
    And user enters the credentials "<username>" "<password>"
    When user clicks login button
    And user clicks the admin button
    And user enters the username "<usernameToSearch>"
    When user clicks the search button
    Then no record should appear
    And user should logout

    Examples: 
      | username | password | usernameToSearch |
      | Admin    | admin123 | Admin            |
