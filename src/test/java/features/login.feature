Feature: Login into Application
Scenario Outline: Positive test validating login

Given Initialize the browser
And Navigate to "http://qaclickacademy.com" site
And click on login link in home page to to land on secure sign in Page
When User enters <username> and <password> and logs in
Then verify that user has successfully logged in
And close the broswer

Examples:
|username							|password		|
|mmvvkk5284@gmail.com |123456			|
|mvk5284@gmail.com		|123456			|
|test99@gmail.com			|97487			|
