@Regression

Feature: Soon In Cinema Page

  As a user
  I want to know about events in the future
  So that they can help me to make plans for the future

  Background:
    Given user open soon page
    And user accept geo location

  Scenario: Soon page load in time
    Then user validate soon page opened

  Scenario: Check soon page headers elements are displayed
    Then user verify "HEADER" element is displayed
    And user verify "LEFT_MENU_BUTTON" element is displayed
    And user verify "LOGO" element is displayed
    And user verify "GEO" element is displayed
    And user verify "RIGHT_MENU_BUTTON" element is displayed
    And user verify "SIGN_IN" element is displayed

  Scenario: Open soon in cinema page and check all elements are displayed
    Then user verify the soon page "SOON_TOP" element is displayed
    And user verify the soon page "MAY_NOT" element is displayed
    And user verify the soon page "SHOW_HINT" element is displayed
    And user verify the soon page "FILM_NAVIGATOR" element is displayed
    And user verify the soon page "SOON_BY_DAY" element is displayed
    And user verify the soon page "ALL_BY_DAY" element is displayed
    And user verify the soon page "POSTER_BLOCK" element is displayed
    And user verify the soon page "POSTER_DATE" element is displayed
    And user verify the soon page "ON_SALE" element is displayed
    And user verify the soon page "POSTER_NAME" element is displayed

  Scenario: User click show hint button and may not hint is displayed
    When user click the soon page "SHOW_HINT" element
    Then user verify the soon page "MAY_NOT_HINT" element is displayed
    And user click the soon page "SHOW_HINT" element
    And user verify the soon page "MAY_NOT_HINT" element is not displayed

  Scenario Outline: User navigate to navigation menu options
    When user click the soon page "<filmNavigatorButton>" element
    Then user verify the soon page "<filmNavigatorButton>" element is active
    And user click the soon page "SHOW_HINT" element
    And user verify the soon page "FILM_NAVIGATOR" element is displayed
    Examples:
      | filmNavigatorButton |
      | FILM_BY_DAY         |
      | THEATRE_BY_DAY      |
      | ALL_BY_DAY          |

