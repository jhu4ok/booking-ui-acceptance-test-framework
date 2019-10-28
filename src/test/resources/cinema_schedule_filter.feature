@Regression

Feature: Cinema Schedule Filter

    As a user
    I want to be able to find cinema schedule
    So that they can be related to my search properties

    Background:
        Given user open cinemas page
        And user accept geo location
        And user click the cinemas page "FIRST_CINEMA" element

    Scenario: Open cinema details and check film filter menu contain all attributes
        And user verify the cinema page "CINEMA_PAGE" element is displayed
        Then user verify the cinema page "SCHEDULE_FILTER" element is displayed
        And user verify the cinema page "FORMATS" element is displayed
        And user verify the cinema page "HALL" element is displayed

    Scenario Outline: Select film format filter and check format filter is selected
        And user verify the cinema page "CINEMA_PAGE" element is displayed
        And user verify the cinema page "SCHEDULE_FILTER" element is displayed
        When user click the cinema page "<filterOption>" element
        Then user verify the cinema page "<filterOption>" element is selected
        And displayed films related "<filterOption>" filter
        Examples:
            | filterOption |
            | 2D           |
            | IMAX L 2D    |
            | IMAX L 3D    |
            | 3D           |
            | KIDS         |
            | USUAL        |
            | LUX          |

    Scenario Outline: User move to filter option and get option hint
        And user verify the cinema page "CINEMA_PAGE" element is displayed
        And user verify the cinema page "SCHEDULE_FILTER" element is displayed
        When user move to cinema page "<filterOption>" element
        Then user verify the cinema page "<filterOption>" hint is displayed
        Examples:
            | filterOption |
            | 2D           |
            | IMAX L 2D    |
            | IMAX L 3D    |
            | 3D           |
            | KIDS         |
            | LUX          |
