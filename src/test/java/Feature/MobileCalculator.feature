Feature: To test the addition feature of the Mobile Calculator

@auto
Scenario Outline: Addition operation

Given the MobileCalculatorApp
When the number one "<num1>" is entered
And the "<operator>" operator is clicked
And the number two "<num2>" is entered
Then the result must be the sum
Examples:
|num1|num2|operator|
|123 |456 |plus    |
