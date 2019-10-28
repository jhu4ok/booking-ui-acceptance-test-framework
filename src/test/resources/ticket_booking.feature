@Regression

Feature: Ticket Booking Page

    As a user
    I want to be to book tickets online
    So that can help me to save my time

    Background:
        Given user open home page
        And user accept geo location
        And user click on home page "POSTER_TITLE" button
        And user verify the film details page opened
        And user click the film page "SESSION_TIME" element

    Scenario: Check ticket booking page elements are displayed
        Then user verify the ticket booking "SEATS_TYPE" element is displayed
        And user verify the ticket booking "STAGE" element is displayed
        And user verify the ticket booking "SEATS" element is displayed
        And user verify the ticket booking "DATA_RATING" element is displayed
        And user verify the ticket booking "CONTINUE_BUTTON" element is displayed

    Scenario: Check ticket booking continue button is working
        And user click the ticket booking "GOOD_SEAT" element
        When user click the ticket booking "CONTINUE_BUTTON" element
        Then user verify the ticket booking "BAR" element is active


