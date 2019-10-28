ACTIVITIES IN SCOPE

UI acceptance testing

TESTING APPROACH

1. Testing will be performed "UA" host
2. Testing will be performed at Chrome browser
3. Payment feuture won't be tested

FEATURES TO BE TESTED

|Feature                 | Descriptions
|------------------------| -------------------------------------------------------------------------|
|[ABOUT COMPANY PAGE]    | *As a* user|
|                        | *I want* to be able to get company information|
|                        | *So that* can help me to find information I am interested in |
|[CINEMA BOARD]          | *As a* user  |
|                        | *I want*|
|                        | *So that*  |
|[CINEMA DETAILS]         | *As a* user |
|                        | *I want* to be able to find cinema information|
|                        | *So that* they can help me to be sure that it related to my expectation |
|[CINEMA FILM LIST]         | *As a* user  |
|                        | *I want* to be able to find cinema films list  |
|                        | *So that* they can help me to find film I am interested in |
|[CINEMA SCHEDULE]        | *As a* user  |
|                        | *I want* to be able to find cinema schedule  |
|                        | *So that* they can be related to my search properties |
|[CINEMA SCHEDULE FILTER]| *As a* user  |
|                        | *I want* to be able to find cinema schedule  |
|                        | *So that* they can be related to my search properties |
|[CINEMA SCHEDULE ADVANCED_FILTER]| *As a* user  |
|                        | *I want* to be able to filter cinemas using advanced filter   |
|                        | *So that* they can be related to my search properties |
|[CINEMAS LIST]| *As a* user |
|                        | *I want* to be able to get cinemas list  |
|                        | *So that* can help me to find nearest cinema  |
|[CINEMAS MAP]| *As a* user |
|                        | *I want* to be able to filter cinemas using map   |
|                        | *So that* it can help me to find nearest cinema |
|[FEEDBACK FORM]| *As a* user |
|                        | *I want* to be able to get feedback form  |
|                        | *So that* can help me to send feedback to cinema|
|[FILM DETAILS]| *As a* user |
|                        | *I want* to be able to find film details   |
|                        | *So that* it can help to know more about film  |
|[FILM SCHEDULE]| *As a* user |
|                        | *I want* to be able to find film schedule  |
|                        | *So that* it can help me to choose film session  |
|[GEO MENU]| *As a* user |
|                        | *I want* to be able select nearest cinema |
|                        | *So that* it can help me search films schedule related my location  |
|[GEO WINDOW]| *As a* user |
|                        | *I want* to be able select nearest cinema  |
|                        | *So that* can help me search films schedule related my location |
|[HELP PAGE]| *As a* user |
|                        | *I want* to be able to have quick access to FAQs  |
|                        | *So that* they can help me to answer on my questions  |
|[HOME PAGE]| *As a* user |
|                        | *I want* to be able to have access to top options  |
|                        | *So that* can help me to get base options on all pages |
|[LANGUAGE]| *As a* user  |
|                        | *I want* to be able to change application language  |
|                        | *So that* can help me to use application |
|[MAIN MENU]| *As a* user  |
|                        | *I want* to access to site options   |
|                        | *So that* they can help me to navigate to other pages |
|[POSTER MENU]| *As a* user |
|                        | *I want* to be able to get all film posters  |
|                        | *So that* it can help me to choose film |
|[PROMOS]| *As a* user |
|                        | *I want* to be able to have access to cinemas promotions |
|                        | *So that* they can help me to choose the best cinemas deals |
|[SOON]| *As a* user  |
|                        | *I want* to know about events in the future   |
|                        | *So that* they can help me to make plans for the future |
|[TICKET BOOKING]| *As a* user |
|                        | *I want* to be to book tickets online   |
|                        | *So that* can help me to save my time |
|[TICKET RETURN]| *As a* user |
|                        | *I want* to be able to return ticket  |
|                        | *So that* they can help me to refund my money |

FEATURES NOT TO BE TESTED

|Feature                 | Descriptions
|------------------------| -------------------------------------------------------------------------|
|[PAYMENT]    | *As a* user|
|                        | *I want* to be able to pay online|
|                        | *So that* can help me to save my time |
|[LOGIN]| *As a* user |
|                        | *I want* to be able to login to personal cabinet   |
|                        | *So that* they can help to find information about my activity |

REGRESSION SUITE

|Feature                 | Scenario
|------------------------| -------------------------------------------------------------------------|
|[ABOUT COMPANY PAGE]    | |
|                        | Open about company page and check all attribute present|
|                        | Open about company page and check all header attribute present|
|                        | Check about company page ticket return form button is working |
|                        | Check about company page  support form  button is working |
|                        | Check about company page advertising form button is working |
|                        | Check about company page career form button is working |
|                        | Check about company page board button is working |
|[CINEMA BOARD]          |   |
|                        | Open cinemas board page and check the page load in time|
|                        | Open cinemas board page and check all attribute present|
|                        | Open cinemas board page and check all header attribute present  |
|                        | Check cinemas board activity button is working |
|[CINEMA DETAILS]         |  |
|                        | Open cinema details and check the page load in time|
|                        | Open cinema details and check all attribute present |
|[CINEMA FILM LIST]      |   |
|                        | Open cinema details and check film list contain all attributes  |
|                        | Move to schedule time and check price is displayed |
|                        | User open film details page from cinema page  |
|[CINEMA SCHEDULE]        |   |
|                        | Open cinema details and check cinema schedule menu contain all attributes  |
|                        | Select schedule date and check date is active |
|                        | Schedule date contain correct date |
|[CINEMA SCHEDULE FILTER]|   |
|                        | Open cinema details and check film filter menu contain all attributes  |
|                        | Select film format filter and check format filter is selected  |
|                        | User move to filter option and get option hint |
|[CINEMA SCHEDULE ADVANCED FILTER]|   |
|                        | Open cinemas list page and check cinemas filter menu contains all attributes  |
|                        | Filter cinemas by city and check selected city is displayed |
|                        | Filter cinemas by comfort and check selected comfort type is displayed |
|                        | Filter cinemas by content and check selected content type is displayed |
|                        | Filter cinemas by additional services and check selected additional services is displayed |
|                        | Filter cinemas by technology and check selected technology type is displayed |
|[CINEMAS LIST]|  |
|                        | Open cinemas list page and check cinemas page headers elements  |
|                        | Open cinema schedule from cinemas list page|
|                        | Open cinemas list page and check cinemas list contain all attributes |
|[CINEMAS MAP]| |
|                        | Open cinemas list page and check cinemas map contains all attributes   |
|                        | Click on cinemas map city and check city cinemas page opened |
|[FEEDBACK FORM]|  |
|                        | Check feedback form elements are displayed  |
|                        | Input details in all fields and send form|
|                        | Send feedback form with empty details|
|[FILM DETAILS]| |
|                        | Open film details page and check all attribute present   |
|                        | Check film details trailer button is working |
|                        | Check film details review button is working |
|                        | Move to year limitation and check limitation hint is displayed |
|[FILM SCHEDULE]|  |
|                        | Select date from drop down menu and check it active  |
|                        | Move to lux hall hint and check lux hall hint displayed  |
|                        | Move to vip hall hint and check vip hall hint displayed  |
|                        | Move to schedule time and check price is displayed  |
|[GEO MENU]| |
|                        | Geo location menu open from home page|
|                        | Geo location menu open when click other location button  |
|                        | Open geo location menu and check all attributes displayed  |
|                        | Check geo menu close button is working  |
|                        | Select optional geo location and check it displayed  |
|                        | Select other geo location and check it displayed  |
|[GEO WINDOW]|  |
|                        | Check home page geo window is displayed on first visit  |
|                        | Accept current geo location |
|                        | Select other geo location |
|[HELP PAGE]|  |
|                        | Check help page load in time  |
|                        | Check help page headers elements displayed  |
|                        | Open help page and check help page elements displayed  |
|                        | Open ticket return form from help page and check return form button is working |
|                        | Open advertising form from help page and check advertising form button is working |
|                        | Open career form from help page and check career form button is working |
|[HOME PAGE]|  |
|                        | Check home page headers elements displayed  |
|                        | Check home posters list elements displayed |
|                        | Check home page move to right button works |
|                        | Move to last home page poster and back |
|[LANGUAGE]| |
|                        | Select other language and check it is active |
|[MAIN MENU]|   |
|                        | Open main menu from home page and check all elements displayed   |
|                        | Open about company from main menu and check button is work |
|                        | Open soon page from main menu and check button is work|
|                        | Open promotions page from main menu and check button is work|
|                        | Open cinemas page from main menu and check button is work|
|                        | Open help page from main menu and check button is work|
|                        | Open login page from main menu and check button is work|
|[POSTER MENU]| |
|                        | Open home page and check film posters displayed  |
|                        | Check advertising posters displayed|
|                        | Check film posters related current location|
|                        | Check film posters contain all needed information|
|                        | Check film schedule on poster related current time|
|                        | Get detailed film information from film poster|
|                        | Open film trailer from film poster|
|                        | Open film ticket booking page from poster film schedule|
|[PROMOS]|  |
|                        | Check promotion page headers elements are displayed |
|                        | Open promotions page and check all elements displayed |
|                        | Move to last promotions poster and back |
|                        | User verify active promotion posters list |
|                        | User verify is over promotion posters list |
|[SOON]|   |
|                        | Soon page load in time   |
|                        | Check soon page headers elements are displayed |
|                        | Open soon in cinema page and check all elements are displayed |
|                        | User click show hint button and may not hint is displayed |
|                        | User navigate to navigation menu options |
|[TICKET BOOKING]|   |
|                        | Check ticket booking page elements are displayed   |
|                        | Check ticket booking continue button is working |
|[TICKET RETURN]|  |
|                        | Check return ticket form elements are displayed |
|                        | Check more options button return ticket form is working |
|                        | Check return ticket elements are displayed |
|                        | Send form with empty fields and check it not send |

END TO END TESTING SCENARIO
1. [HOME PAGE]:
Open cinema web page.
2. [GEO MENU]:
Choose geo location.
3. [FILM DETAILS]:
Choose film details.
4. [FILM SCHEDULE]: 
Choose film session.
5. [TICKET BOOKING]: 
Book seats 
6. [PAYMENT]: 
*Pay for tickets 
