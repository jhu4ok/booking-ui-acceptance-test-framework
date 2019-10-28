@Regression

Feature: Language Options

    As a user
    I want to be able to change application language
    So that can help me to use application

    Scenario Outline: Select other language and check it is active
        Given user open home page
        And user accept geo location
        And user open the main menu
        And user verify the main menu "LANGUAGE_OPTIONS" element is displayed
        When user click the main menu "<language>" element
        And user open the main menu
        Then user verify the main menu "<language>" element is active
        Examples:
            | language |
            | RU       |
            | UA       |
