@Regression

Feature: Home Page

    As a user
    I want to be able to have access to top options
    So that can help me to get base options on all pages

    Background:
        Given user open home page
        And user accept geo location

    Scenario: Check home page headers elements displayed
        Then user verify "HEADER" element is displayed
        And user verify "LEFT_MENU_BUTTON" element is displayed
        And user verify "LOGO" element is displayed
        And user verify "GEO" element is displayed
        And user verify "RIGHT_MENU_BUTTON" element is displayed
        And user verify "SIGN_IN" element is displayed

    Scenario: Check home posters list elements displayed
        Then user verify the home page "POSTER_LIST" element is displayed
        And user verify the home page "MOVE_TO_RIGHT" element is displayed
        And user verify the home page "MOVE_TO_LEFT" element is not displayed

    Scenario: Check home page move to right button works
        And user verify
        And user verify the home page "MOVE_TO_RIGHT" element is displayed
        And user verify the home page "MOVE_TO_LEFT" element is not displayed
        When user click on "MOVE_TO_RIGHT" button
        Then user verify the home page "MOVE_TO_LEFT" element is displayed
        And user verify the home page "MOVE_TO_RIGHT" element is displayed

    Scenario: Move to last home page poster and back
        And user accept geo location
        Then user verify "POSTER_LIST" element is displayed
        And user verify "MOVE_TO_RIGHT" element is displayed
        And user verify "MOVE_TO_LEFT" element is not displayed
        When user move to "last" poster
        And user verify "MOVE_TO_LEFT" element is displayed
        And user verify "MOVE_TO_RIGHT" element is not displayed
        When user move to "first" poster
        And user verify "MOVE_TO_RIGHT" element is displayed
        And user verify "MOVE_TO_LEFT" element is not displayed
