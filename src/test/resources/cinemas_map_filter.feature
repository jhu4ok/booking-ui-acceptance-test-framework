@Regression

Feature: Cinemas Map Filter

    As a user
    I want to be able to filter cinemas using map
    So that it can help me to find nearest cinema

    Background:
        Given user open cinemas page
        And user accept geo location
        And user validate cinemas page opened

    Scenario: Open cinemas list page and check cinemas map contains all attributes
        Then user verify the cinemas page "MAP_TOP" element is displayed
        And user verify the cinemas page "MAP" element is displayed

    Scenario Outline: Click on cinemas map city and check city cinemas page opened
        When user click the cinemas page map "<cityName>" element
        When user validate the cinemas "<cityName>" page opened
        Examples:
            | cityName     |
            | lviv         |
            | lutsk        |
            | rivne        |
            | khmelnytskyi |
            | zhytomyr     |
            | odesa        |
            | kyiv         |
            | cherkasy     |
            | mykolaiv     |
            | chernihiv    |
            | poltava      |
            | kherson      |
            | kryvyi_rih   |
            | dnipro       |
            | zaporizhia   |
            | kharkiv      |
            | mariupol     |
