@Regression

Feature: Cinemas List Page

    As a user
    I want to be able to get cinemas list
    So that can help me to find nearest cinema

    Background:
        Given user open cinemas page
        And user accept geo location
        And user validate cinemas page opened

    Scenario: Open cinemas list page and check cinemas page headers elements
        And user accept geo location
        Then user verify "LEFT_MENU_BUTTON" element is displayed
        And user verify "LOGO" element is displayed
        And user verify "GEO" element is displayed
        And user verify "RIGHT_MENU_BUTTON" element is displayed
        And user verify "SIGN_IN" element is displayed

    Scenario: Open cinemas list page and check cinemas list contain all attributes
        Then user verify the cinemas page cinema list "CINEMA_POSTER" is displayed
        And user verify the cinemas page cinema list "CINEMA_NAME" is displayed
        And user verify the cinemas page cinema list "CITY_NAME" is displayed
        And user verify the cinemas page cinema list "CINEMA_ADDRESS" is displayed
        And user verify the cinemas page cinema list "CINEMA_SCHEDULE" is displayed
        And user verify the cinemas page cinema list "CINEMA_FEATURES" is displayed

    Scenario Outline: Open cinema schedule from cinemas list page
        When user click the cinemas page "<buttonName>" element
        Then user verify the cinema page opened
        Examples:
            | buttonName             |
            | CINEMA_POSTER_BUTTON   |
            | CINEMA_SCHEDULE_BUTTON |
