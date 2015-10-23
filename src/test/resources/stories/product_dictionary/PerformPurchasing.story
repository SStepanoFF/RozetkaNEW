Buying item on rozetka.com.ua
Narrative:
In order to buy an cell phone
As a user
I want to buy an Iphone 6 16Gb Space Gray

Scenario: Purchasing the item of Iphone 6 16GB Space Gray
Given the user opens rozetka store
Given the user looks for 'Apple iPhone 6 16GB' 'Space Gray'
When the user buys the item
Then cart should appear
Then the item should exist in the cart
Then the item should be on '1'th position in the cart
Then the user closes cart

Scenario: Purchasing the item with inaccurate name
Given the user opens rozetka store
Given the user looks for 'macbook' '13"'
Then the user selects the 'notebooks' category
Then the user buys the item
When cart appeared
Then the item should exist in the cart
Then the user closes cart

Scenario: Checking the position of purchased item
Given the user opens rozetka store
Given the user looks for 'Samsung Galaxy' 'Black'
Then the user selects the 'smartphones' category
When the user click on the given item
Then the item details page should appear
Then the user click on buy button from the Product Details Page
When cart appeared
Then the item should exist in the cart
Then the item should be on '1'th position in the cart
Then the user closes cart