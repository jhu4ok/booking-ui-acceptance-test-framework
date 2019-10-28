@Regression

Feature: Help Page

    As a user
    I want to be able to have quick access to FAQs
    So that they can help me to answer on my questions

    Background:
        Given user open help page

    Scenario: Check help page load in time
        Then user validate help page opened

    Scenario: Check help page headers elements displayed
        And user accept geo location
        Then user verify "HEADER" element is displayed
        And user verify "LEFT_MENU_BUTTON" element is displayed
        And user verify "LOGO" element is displayed
        And user verify "GEO" element is displayed
        And user verify "RIGHT_MENU_BUTTON" element is displayed
        And user verify "SIGN_IN" element is displayed

    Scenario: Open help page and check help page elements displayed
        And user accept geo location
        Then user verify the help page "ASK" element is displayed
        Then user verify the help page "RIGHT_MENU" element is displayed
        Then user verify the help page "PHONE_BUTTON" element is displayed

    Scenario: Open ask menu from help page and check ask menu button is working
        And user accept geo location
        When user click the help page "ASK" element
        Then user verify the help page "SUPPORT_OPTIONS" element is displayed
        And user verify the help page "TICKET_RETURN" element is displayed
        And user verify the help page "SUPPORT" element is displayed
        And user verify the help page "ADVERTISING" element is displayed
        And user verify the help page "CAREER" element is displayed

    Scenario: Open ticket return form from help page and check return form button is working
        And user accept geo location
        When user click the help page "ASK" element
        When user click the help page "TICKET_RETURN" element
        Then user verify the ticket return form "TICKET_RETURN" element is displayed

    Scenario: Open ticket return form from help page and check support form button is working
        And user accept geo location
        When user click the help page "ASK" element
        When user click the help page "SUPPORT" element
        Then user verify the feedback form "SUPPORT" element is displayed

    Scenario: Open advertising form from help page and check advertising form button is working
        And user accept geo location
        When user click the help page "ASK" element
        When user click the help page "ADVERTISING" element
        Then user verify the advertising form "ADVERTISING" element is displayed

    Scenario: Open career form from help page and check career form button is working
        And user accept geo location
        When user click the help page "ASK" element
        When user click the help page "CAREER" element
        Then user verify the career form "CAREER" element is displayed
