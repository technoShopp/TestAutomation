Feature: Validate the Library API



@regression
Scenario Outline: Validate the ADD Place One API with Parameterization and DD
Given the query parameter and the payload 
When the "<HTTPMethod>" request is hit
Then the statusCode should be "<statusCode>"
Examples:
|HTTPMethod|statusCode|
|post      |200       |
