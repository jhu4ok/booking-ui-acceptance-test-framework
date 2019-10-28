@Regression

Feature: Cinema Film Schedule

    As a user
    I want to be able to find cinema schedule
    So that they can be related to my search properties

    Background:
        Given user open cinemas page
        And user accept geo location
        And user click the cinemas page "FIRST_CINEMA" element

    Scenario: Open cinema details and check cinema schedule menu contain all attributes
        And user verify the cinema page "CINEMA_PAGE" element is displayed
        Then user verify the cinema page "SCHEDULE_HEADER" element is displayed
        And user verify the cinema page schedule date elements contain "SCHEDULE_DAY"
        And user verify the cinema page schedule date elements contain "SCHEDULE_DAY_NAME"


    Scenario: Schedule date contain correct date
        And user verify the cinema page "CINEMA_PAGE" element is displayed
        Then user verify the cinema page schedule date value is correct

    Scenario: Select schedule date and check date is active
        And user verify the cinema page "CINEMA_PAGE" element is displayed
        When user click the cinema page "NEXT_DAY" element
        Then user verify the cinema page "NEXT_DAY" element is active
