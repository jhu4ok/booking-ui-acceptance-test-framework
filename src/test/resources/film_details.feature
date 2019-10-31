@Regression

Feature: Film details Page

    As a user
    I want to be able to find film details
    So that it can help to know more about film

    Background:
        Given user open home page
        And user accept geo location
        And user click on home page "POSTER_TITLE" button
        And user verify the film details page opened

    Scenario: Open film details page and check all attribute present
        Then user verify the film page "POSTER" element is displayed
        And user verify the film page "FILM_TITLE" element is displayed
        And user verify the film page "YEAR_RATING" element is displayed
        And user verify the film page "FILM_CREDENTIALS" element is displayed
        And user verify the film page "FILM_DESCRIPTION" element is displayed

    Scenario: Check film details trailer button is working
        When user click the film page "TRAILER_BUTTON" element
        Then user verify the film page "VIDEO" element is displayed

    Scenario: Check film details review button is working
        When user click the film page "REVIEW_BUTTON" element
        Then user verify the film page "VIDEO" element is displayed

    Scenario: Move to year limitation and check limitation hint is displayed
        When user move to film page "YEAR_RATING" element
        And user click the film page "YEAR_RATING" element
        Then user verify the film page "YEAR_HINT" element is displayed
