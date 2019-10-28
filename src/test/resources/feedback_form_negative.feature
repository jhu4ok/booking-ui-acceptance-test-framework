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

    Scenario: Send feedback form with empty details
        When user click the feedback form "SUBMIT_BUTTON" element
        Then user verify the feedback form "EMAIL_INPUT_INVALID" element is displayed
        Then user verify the feedback form "MESSAGE_INPUT_INVALID" element is displayed
        Then user verify the feedback form "PHONE_INPUT_INVALID" element is displayed


