@Regression

Feature: Geo Location Window

  As a user
  I want to be able select nearest cinema
  So that can help me search films schedule related my location

  Background:
    Given user open home page with geo window

  Scenario: Check home page geo window is displayed on first visit
    Then user verify the geo window "GEO_WINDOW" element is displayed
    And user verify the geo window "ACCEPT_LOCATION" element is displayed
    And user verify the geo window "OTHER_LOCATION" element is displayed

  Scenario: Accept current geo location
    And user verify the geo window "GEO_WINDOW" element is displayed
    When user accept geo location
    Then user verify "PROPOSED" location is selected

  Scenario: Select other geo location
    And user verify the geo window "GEO_WINDOW" element is displayed
    When user click on geo window other location button
    Then user verify the geo window "GEO_MENU" element is displayed




