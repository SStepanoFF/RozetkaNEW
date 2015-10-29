Add comment for product story

Narrative:
In order to view product details
As a user
I want to make comments for product

Scenario:  Add comment for MacBook notepad with 13"
Given the user opens a product details page url 'http://rozetka.com.ua/apple_macbook_air_zorj000n9/p2541567/'
And product is 'Ноутбук' with '13"'
When the user 'Sergii' with email 'tester2@test.com' add text 'test comment' to the comment field
Then the comment is added