#Each feature files contains one feature
#Feature files use Gherkin language - Business language
Feature: Test the login functionality on sdet university

#A feature may have given different specific scenarios
#Scenarios use Given-When-Then structure
Scenario: the user should be able to login with correct username and correct password
Given user is on the login page
When user enters correct username and correct password
Then user gets confirmation

Scenario Outline: the user should be able to login
Given user is on the login page
When user enters email <username>
And user enters password <password>
Then user gets confirmation

Examples:
| username | password |
| raviraj@yopmail.com | thbs123! |
| abhi@yopmail.com | hello1 |
| ravi@yopmail.com | hello |