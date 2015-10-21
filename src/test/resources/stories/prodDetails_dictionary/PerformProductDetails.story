Product Details story
Narrative:
In order to view product details
As a user
I want to open product details page, make comments and add product to the wishlist
					 
Scenario:  add comment for MacBook notepad with 13"
Given the user opens a product details page
And product is 'Ноутбук' with '13"'
When the user 'Sergii' with email 'tester2@test.com' add text 'test comment' to the comment field
Then comment is added to product
					 
Scenario:  add product to the wishlist
Given wishlist btn is available
When the user clicks on Add to Wishlist btn
Then product is added to wishlist