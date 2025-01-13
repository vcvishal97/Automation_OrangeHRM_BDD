Feature: login feature

  @smoke
  Scenario Outline: login should be successful
    Given user launches the applicatio
    And user enters the credentials "<username>" "<password>"
    When user clicks login button
    Then user should be logged in
    And user should logout

    Examples:
      | username | password |
      | Admin    | admin123 |

  @smoke
  Scenario Outline: login should not be successful
    Given user launches the applicatio
    And user enters the credentials "<username>" "<password>"
    When user clicks login button
    Then login should fail

    Examples:
      | username | password |
      | aaa      | bbb      |
