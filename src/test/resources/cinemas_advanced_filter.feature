@Regression

Feature: Cinema Advanced Filter

    As a user
    I want to be able to filter cinemas using advanced filter
    So that they can be related to my search properties

    Background:
        Given user open cinemas page
        And user accept geo location
        And user validate cinemas page opened

    Scenario: Open cinemas list page and check cinemas filter menu contains all attributes
        Then user verify the cinemas page "CINEMAS_FILTER" element is displayed
        And user verify the cinemas page "FILTER_AREA" elements are displayed

    Scenario: Filter cinemas by city and check selected city is displayed
        When user click the cinemas page "CITIES_DROP_DOWN" element
        And user click the cinemas page "DROP_DOWN_CITY" element
        Then user validate cinemas related "DROP_DOWN_CITY" filter

    Scenario Outline: Filter cinemas by comfort and check selected comfort type is displayed
        When user click the cinemas page "<filterOption>" element
        Then user verify the cinemas page "<filterOption>" element is selected
        And  user validate cinemas related "<filterOption>" filter
        Examples:
            | filterOption |
            | EASY PASS    |
            | VIP          |
            | LUX          |
            | DISABLED     |
            | TURNSTILE    |
            | CHILL OUT    |

    Scenario Outline: Filter cinemas by content and check selected content type is displayed
        When user click the cinemas page "<filterOption>" element
        Then user verify the cinemas page "<filterOption>" element is selected
        And  user validate cinemas related "<filterOption>" filter
        Examples:
            | filterOption   |
            | FOOTBALL       |
            | THEATRE        |
            | ORIGINAL VOICE |

    Scenario Outline: Filter cinemas by additional services and check selected additional services is displayed
        When user click the cinemas page "<filterOption>" element
        Then user verify the cinemas page "<filterOption>" element is selected
        And  user validate cinemas related "<filterOption>" filter
        Examples:
            | filterOption |
            | M CAFE       |
            | HALL ORDER   |
            | HALL RENT    |
            | PHOTO        |
            | GAMES        |
            | M CLUB       |
            | KIDS ROOM    |

    Scenario Outline: Filter cinemas by technology and check selected technology type is displayed
        When user click the cinemas page "<filterOption>" element
        Then user verify the cinemas page "<filterOption>" element is selected
        And  user validate cinemas related "<filterOption>" filter
        Examples:
            | filterOption |
            | TWINS        |
            | IMAX         |
            | LASER        |
            | SCREENX      |
