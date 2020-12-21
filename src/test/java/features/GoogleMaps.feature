Feature: Validate the Google Maps Add and Get feature

@regression
Scenario: Validate the ADD Place One API service updated
Given the query parameter and the payload 
When the POST request is hit for the end point URL
Then the STATUSCODE should be OK


Scenario: Validate the ADD Place Two API
Given the query parameter and the payload 
When the POST two request is hit for the end point URL
Then the STATUSCODE two should be OK


Scenario: Validate the ADD Place Three API
Given the query parameter and the payload 
When the POST three request is hit for the end point URL
Then the STATUSCODE three should be OK



Scenario: Validate the ADD Place One API
Given the query parameter and the payload 
When the "post" request is hit
Then the statusCode should be "200"


Scenario Outline: Validate the ADD Place One API with Parameterization and DD
Given the query parameter and the payload 
When the "<HTTPMethod>" request is hit
Then the statusCode should be "<statusCode>"
Examples:
|HTTPMethod|statusCode|
|post      |200       |
