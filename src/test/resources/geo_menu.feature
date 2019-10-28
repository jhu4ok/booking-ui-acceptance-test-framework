@Regression

Feature: Geo Location Menu

    As a user
    I want to be able select nearest cinema
    So that it can help me search films schedule related my location

    Background:
        Given user open home page with geo window

    Scenario: Geo location menu open when click other location button
        And user verify the geo window "GEO_WINDOW" element is displayed
        When user click the geo window "OTHER_LOCATION" element
        Then user verify the geo menu "GEO_MENU" element is displayed
        And user verify the geo menu "CITY_LIST" element is displayed
        And user verify the geo menu "CINEMA_LIST" element is displayed
        And user click the geo menu "CLOSE_BUTTON" element

    Scenario: Geo location menu open from home page
        And user verify the geo window "GEO_WINDOW" element is displayed
        When user click the geo menu "GEO_SELECT" element
        And user verify the geo menu "GEO_MENU" element is displayed
        And user verify the geo menu "CITY_LIST" element is displayed
        And user verify the geo menu "CINEMA_LIST" element is displayed
        And user click the geo menu "CLOSE_BUTTON" element

    Scenario: Open geo location menu and check all attributes displayed
        When user click the geo menu "GEO_SELECT" element
        Then user verify the geo menu "GEO_MENU" element is displayed
        And user verify the geo menu "CITY_LIST" element is displayed
        And user verify the geo menu "CINEMA_LIST" element is displayed
        And user verify the geo menu "CLOSE_BUTTON" element is displayed

    Scenario: Check geo menu close button is working
        And user click the geo menu "GEO_SELECT" element
        And user verify the geo menu "GEO_MENU" element is displayed
        And user verify the geo menu "CITY_LIST" element is displayed
        And user verify the geo menu "CINEMA_LIST" element is displayed
        And user verify the geo menu "CLOSE_BUTTON" element is displayed
        When user click the geo menu "CLOSE_BUTTON" element
        Then user verify the geo menu is not displayed

    Scenario Outline: Select optional geo location and check it displayed
        And user click the geo menu "GEO_SELECT" element
        And user verify the geo menu "GEO_MENU" element is displayed
        When user click the geo menu "<cityName>" city list button
        Then user verify "<cityName>" city list button is active
        And user verify "<cityName>" city cinemas list
        Examples:
            | cityName     |
            | DNIPRO       |
            | LVIV         |
            | ODESA        |
            | ZAPORIZHZHIA |
            | MUKOLAIV     |
            | KHERSON      |
            | KHARKIV      |
            | KHMELNIYSKY  |
            | ZHYTOMYR     |
            | KRYVYI_RIH   |
            | MARIUPOL     |
            | RIVNE        |
            | CHERNIHIV    |
            | POLTAVA      |
            | LUTSK        |
            | CHERKASY     |
            | KYIV         |

    Scenario Outline: Select other geo location and check it displayed
        And user click the geo menu "GEO_SELECT" element
        And user verify the geo menu "GEO_MENU" element is displayed
        And user click on "<cityName>" city list button
        And user verify the geo menu "GEO_MENU" element is displayed
        And user verify "<cityName>" city list button is active
        And user verify "<cityName>" city cinemas list
        When user select first cinema from "<cityName>" cinema list
        Examples:
            | cityName     |
            | DNIPRO       |
            | LVIV         |
            | ODESA        |
            | ZAPORIZHZHIA |
            | MUKOLAIV     |
            | KHERSON      |
            | KHARKIV      |
            | KHMELNIYSKY  |
            | ZHYTOMYR     |
            | KRYVYI_RIH   |
            | MARIUPOL     |
            | RIVNE        |
            | CHERNIHIV    |
            | POLTAVA      |
            | LUTSK        |
            | CHERKASY     |
            | KYIV         |
