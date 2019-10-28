@Regression

Feature: Cinema Films List

    As a user
    I want to be able to find cinema films list
    So that they can help me to find film I am interested in

    Background:
        Given user open cinemas page
        And user accept geo location
        And user click the cinemas page "FIRST_CINEMA" element

    Scenario: Open cinema details and check film list contain all attributes
        And user verify the cinema page "CINEMA_PAGE" element is displayed
        And user verify the cinema details "ACTIVE_FILMS" elements are displayed
        Then user verify the cinema page "ACTIVE_FILMS" elements contain "ACTIVE_FILMS_SESSIONS"
        Then user verify the cinema page "ACTIVE_FILMS" elements contain "ACTIVE_FILMS_SESSIONS_TIME"
        Then user verify the cinema page "ACTIVE_FILMS" elements contain "ACTIVE_FILMS_TITLE"


    Scenario: Move to schedule time and check price is displayed
        And user verify the cinema page "CINEMA_PAGE" element is displayed
        When user move to cinema page "INFO" element
        When user move to cinema page "TIME" element
        Then user verify the cinema page "PRICE" element is displayed

    Scenario Outline: User open film details page from cinema page
        And user verify the cinema page "CINEMA_PAGE" element is displayed
        When user click the cinema page "<buttonName>" element
        Then user verify the film details page opened
        Examples:
            | buttonName |
            | POSTER     |
            | FILM_NAME  |

