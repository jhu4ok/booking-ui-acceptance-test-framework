@RegressionLOC

Feature: Film Schedule

    As a user
    I want to be able to find film schedule
    So that it can help me to choose film session

    Background:
        Given user open home page
        And user accept geo location
        And user click on home page "POSTER_TITLE" button
        And user verify the film details page opened

    Scenario: Select date from drop down menu and check it active
        When user click the film page "SELECT_DATE" element
        And user click the film page "NEXT_DAY" element
        Then user verify selected date is active
