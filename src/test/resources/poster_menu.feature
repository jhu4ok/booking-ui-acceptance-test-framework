@Regression

Feature: Poster Menu

    As a user
    I want to be able to get all film posters
    So that it can help me to choose film

    Background:
        Given user open home page
        And user accept geo location

#    Scenario: Open home page and check film posters displayed
##    Then  film posters displayed
#
#    Scenario: Check advertising posters displayed
##    Then  film posters displayed
##
#    Scenario: Check film posters related current location
##    And  film posters displayed
##    Then  user validate all film posters related current location
#
    Scenario: Check film posters contain all needed information
        Then user verify the home page "POSTER_LIST" element is displayed
        And user verify the home page "POSTER_TITLE" element is displayed
        And user click on home page "FILM_DETAILS_BUTTON" button

#    And  film posters displayed
#    When user move mouse on poster
#  Then user validate film detailed information button is displayed
#  Then user validate film trailer button is displayed
#  Then user validate film name is displayed
#  Then user validate film schedule is displayed

#    Scenario: Check film schedule on poster related current time
##    And  film posters displayed
##    When user move mouse on poster
##  Then user validate film schedule related current time
#
#    Scenario: Get detailed film information from film poster
##    And  film posters displayed
##    And user move mouse on poster
##  When click on film detailed information button
##  Then click on film detailed information page opened
##
#    Scenario: Open film trailer from film poster
##    And  film posters displayed
##    And user move mouse on poster
##  When click on film trailer button
##  Then film trailer is displayed
#
#    Scenario: Open film ticket booking page from poster film schedule
##    And  film posters displayed
##    And user move mouse on poster
##  When click on nearest film session
##  Then ticked booking page opened


