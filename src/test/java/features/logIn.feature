Feature: User Login

  @login @smokeTest
  Background:
    Given the user navigates to the landing page

  Scenario Outline: User Signs In Successfully
    Then the user should see the text "Sign in" on the page
    When the user enters the username "<username>" and password "<password>"
    Then the user should be signed in successfully

    Examples:
      | username          | password |
      | jiraone@email.com | pass     |

