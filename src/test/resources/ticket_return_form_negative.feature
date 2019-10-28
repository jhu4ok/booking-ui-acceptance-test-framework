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

  Scenario: Send form with empty fields and check it not send
    And user verify the ticket return form "TICKET_RETURN" element is displayed
    When user click the ticket return form "SEND_FORM" element
    Then user verify the ticket return form "INPUT_PHONE_INVALID" element is displayed
    Then user verify the ticket return form "INPUT_CARD_LAST_INVALID" element is displayed
