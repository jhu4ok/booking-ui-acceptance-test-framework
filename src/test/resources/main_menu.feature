@Regression
Feature: Main Menu

    As a user
    I want to access to site options
    So that they can help me to navigate to other pages

    Background:
        Given user open home page
        And user accept geo location

    Scenario: Open main menu from home page and check all elements displayed
        When user open the main menu
        Then user verify the main menu "LEFT_MENU" element is displayed
        And user verify the main menu "CLOSE_BUTTON" element is displayed
        And user verify the main menu "MENU_LOGO" element is displayed
        And user verify the main menu "LANGUAGE_OPTIONS" element is displayed
        And user verify the main menu "SOON" element is displayed
        And user verify the main menu "PROMOTIONS" element is displayed
        And user verify the main menu "CINEMAS" element is displayed
        And user verify the main menu "HELP" element is displayed
        And user verify the main menu "ABOUT_COMPANY" element is displayed
        And user verify the main menu "LOGIN" element is displayed
        And user verify the main menu "PHONE" element is displayed
        And user verify the main menu "SOCIAL_MEDIA" element is displayed

    Scenario: Open about company from main menu and check button is work
        And user open the main menu
        When user click the main menu "ABOUT_COMPANY" element
        Then user validate about company page opened

    Scenario: Open soon page from main menu and check button is work
        And user open the main menu
        When user click the main menu "SOON" element
        Then user validate soon page opened

    Scenario: Open promotions page from main menu and check button is work
        And user open the main menu
        When user click the main menu "PROMOTIONS" element
        Then user validate promotions page opened

    Scenario: Open cinemas page from main menu and check button is work
        And user open the main menu
        When user click the main menu "CINEMAS" element
        Then user validate cinemas page opened

    Scenario: Open help page from main menu and check button is work
        And user open the main menu
        When user click the main menu "HELP" element
        Then user validate help page opened

    Scenario: Open login page from main menu and check button is work
        And user open the main menu
        When user click the main menu "LOGIN" element
        Then user validate login page opened
