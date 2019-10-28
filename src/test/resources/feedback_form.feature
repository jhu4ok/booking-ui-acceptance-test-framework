@Regression

Feature: Feedback Form

    As a user
    I want to be able to get feedback form
    So that can help me to send feedback to cinema

    Background:
        Given user open about company page
        And user accept geo location
        And user click the about company page "FEEDBACK" element
        And user click the about company page "SUPPORT" element

    Scenario: Check feedback form elements are displayed
        Then user verify the feedback form "HEADING" element is displayed
        And user verify the feedback form "NAME_INPUT" element is displayed
        And user verify the feedback form "EMAIL_INPUT" element is displayed
        And user verify the feedback form "PHONE_INPUT" element is displayed
        And user verify the feedback form "ENQUIRE_TYPE_INPUT" element is displayed
        And user verify the feedback form "MESSAGE_INPUT" element is displayed
        And user verify the feedback form "SUBMIT_BUTTON" element is displayed
        And user verify the feedback form "CANCEL_BUTTON" element is displayed

    Scenario: Input details in all fields and send form
        When user click the feedback form "CANCEL_BUTTON" element
        Then user verify the feedback form "HEADING" element is not displayed

