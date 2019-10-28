@Regression
Feature: Ticket Return Form

  As a user
  I want to be able to return ticket
  So that they can help me to refund my money

  Background:
    Given user open about company page
    And user accept geo location
    And user click the about company page "FEEDBACK" element
    And user click the about company page "TICKET_RETURN" element

  Scenario: Check return ticket form elements are displayed
    Then user verify the ticket return form "TICKET_RETURN" element is displayed
    And user verify the ticket return form "CLOSE_BUTTON" element is displayed
    And user verify the ticket return form "SELECT_CINEMA_BUTTON" element is displayed
    And user verify the ticket return form "INPUT_PHONE" element is displayed
    And user verify the ticket return form "INPUT_CARD_FIRST" element is displayed
    And user verify the ticket return form "INPUT_CARD_LAST" element is displayed
    And user verify the ticket return form "EMERGENT_TEXT" element is displayed
    And user verify the ticket return form "SEND_FORM" element is displayed
    And user verify the ticket return form "CANCEL_BUTTON" element is displayed
    And user verify the ticket return form "MORE_OPTIONS" element is displayed

  Scenario: Check more options button return ticket form is working
    When user click the ticket return form "MORE_OPTIONS" element
    Then user verify the ticket return advanced form "TICKET_RETURN_ADVANCED" element is displayed

  Scenario Outline: Check return ticket elements are displayed
    When user click the ticket return form "<buttonName>" element
    Then user verify the ticket return form "TICKET_RETURN" element is not displayed
    Examples:
      | buttonName    |
      | CANCEL_BUTTON |
      | CLOSE_BUTTON  |
