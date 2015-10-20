Login/Logout story

Narrative:
In order to rozetka functionality
As a user
I want to login and logout to the site
					 
Scenario: Loging into store
Given the user opens rozetka
Given the user opens login form
When the user enters username: 'conectic@list.ru' and password 'roman536879'
Then the user clicks on the submit button
Then the profile link should be displayed

Scenario: Logout from store
Given the user is logged in
When the user clicks logOut btn
Then the sign link should be displayed