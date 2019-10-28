@Regression

Feature: Cinema Details Page

    As a user
    I want to be able to find cinema information
    So that they can help me to be sure that it related to my expectation

    Background:
        Given user open cinemas page
        And user accept geo location

    Scenario: Open cinema details and check the page load in time
        And user validate cinemas page opened
        When user click the cinemas page "FIRST_CINEMA" element
        Then user verify the cinema page "CINEMA_PAGE" element is displayed

    Scenario: Open cinema details and check all attribute present
        When user click the cinemas page "FIRST_CINEMA" element
        And user verify the cinema page "CINEMA_PAGE" element is displayed
        Then user verify the cinema page "CINEMA_NAME" element is displayed
        And user verify the cinema page "STREET_ADDRESS" element is displayed
        And user verify the cinema page "ADDRESS_LOCALITY" element is displayed
        And user verify the cinema page "TELEPHONE" element is displayed
        And user verify the cinema page "SCHEDULE_FILTER" element is displayed
        And user verify the cinema page "SCHEDULE_FILM" element is displayed
        And user verify the cinema page "FORMATS" element is displayed
        And user verify the cinema page "CINEMA_PICS" element is displayed
        And user verify the cinema page "CINEMA_RULES" element is displayed
