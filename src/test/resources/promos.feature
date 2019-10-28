@Regression
Feature: Promotions Page

    As a user
    I want to be able to have access to cinemas promotions
    So that they can help me to choose the best cinemas deals

    Background:
        Given user open promotions page
        And user accept geo location

    Scenario: Promotions company page load in time
        Then user validate promotions page opened

    Scenario: Check promotion page headers elements are displayed
        Then user verify "HEADER" element is displayed
        And user verify "LEFT_MENU_BUTTON" element is displayed
        And user verify "LOGO" element is displayed
        And user verify "GEO" element is displayed
        And user verify "RIGHT_MENU_BUTTON" element is displayed
        And user verify "SIGN_IN" element is displayed

    Scenario: Open promotions page and check all elements displayed
        Then user verify the promotions page "PROMO_LIST" element is displayed
        Then user verify "MOVE_TO_RIGHT" element is displayed

    Scenario: Move to last promotions poster and back
        And user accept geo location
        Then user verify the promotions page "PROMO_LIST" element is displayed
        And user verify "MOVE_TO_RIGHT" element is displayed
        And user verify "MOVE_TO_LEFT" element is not displayed
        When user move to "last" poster
        And user verify "MOVE_TO_LEFT" element is displayed
        And user verify "MOVE_TO_RIGHT" element is not displayed
        When user move to "first" poster
        And user verify "MOVE_TO_RIGHT" element is displayed
        And user verify "MOVE_TO_LEFT" element is not displayed

    Scenario: User verify active promotion posters list
        And user verify the promotions page "PROMO_LIST" element is displayed
        And user verify the promotions page "ACTIVE_PROMOS" elements are present
        And user verify the promotions page "PROMO_HOLDER_IS_ACTIVE" elements are present
        And user verify the promotions page "PROMO_BOTTOM_IS_ACTIVE" elements are present

    Scenario: User verify is over promotion posters list
        And user verify the promotions page "PROMO_LIST" element is displayed
        And user verify the promotions page "IS_OVER_PROMOS" elements are present
        And user verify the promotions page "PROMO_HOLDER_IS_OVER" elements are present
        And user verify the promotions page "PROMO_BOTTOM_IS_OVER" elements are present
