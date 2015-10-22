Add product to wishlist story

Narrative:
In order to product details functionality
As a user
I want to add product to the wishlist
					 
Scenario:  add product to the wishlist
Given product details page is opened
And the user 'sergiistepanov85@gmail.com' with password 'sergii123' login to rozetka store
And wishlist is empty
When the user clicks on Add to Wishlist btn
Then product is added to wishlist