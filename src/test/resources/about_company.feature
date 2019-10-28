@Regression

Feature: About Company Information Page

    As a user
    I want to be able to get company information
    So that can help me to find information I am interested in

    Background:
        Given user open about company page
        And user accept geo location

    Scenario: Open about company page and check the page load in time
        Then user validate about company page opened

    Scenario: Open about company page and check all attribute present
        Then user verify the about company page "LEFT_MENU" element is displayed
        And user verify the about company page "RIGHT_MENU" element is displayed
        And user verify the about company page "TICKET_RETURN" element is displayed
        And user verify the about company page "SUPPORT" element is displayed
        And user verify the about company page "ADVERTISING" element is displayed
        And user verify the about company page "CAREER" element is displayed

    Scenario: Open about company page and check all header attribute present
        Then user verify "LEFT_MENU_BUTTON" element is displayed
        And user verify "LOGO" element is displayed
        And user verify "GEO" element is displayed
        And user verify "RIGHT_MENU_BUTTON" element is displayed
        And user verify "SIGN_IN" element is displayed

    Scenario: Check about company page ticket return form button is working
        When user click the about company page "TICKET_RETURN" element
        Then user verify the ticket return form "TICKET_RETURN" element is displayed

    Scenario: Check about company page  support form  button is working
        When user click the about company page "SUPPORT" element
        Then user verify the feedback form "SUPPORT_FEEDBACK" element is displayed

    Scenario: Check about company page advertising form button is working
        When user click the about company page "ADVERTISING" element
        Then user verify the advertising form "ADVERTISING_FEEDBACK" element is displayed

    Scenario: Check about company page career form button is working
        When user click the about company page "CAREER" element
        Then user verify the career form "CAREER_FEEDBACK" element is displayed

    Scenario: Check about company page board button is working
        When user click the about company page "BOARD" element
        Then user validate board page opened
