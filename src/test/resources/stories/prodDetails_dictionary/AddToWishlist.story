Meta:
Add product to wishlist story

Narrative:
In order to product details functionality
As a user
I want to add product to the wishlist.

Scenario:  Add product to the wishlist and delete added item.
Given product details page url 'http://rozetka.com.ua/apple_macbook_air_zorj000n9/p2541567/' is opened
And the user 'sergiistepanov85@gmail.com' with password 'sergii123' login to rozetka store
When the user clicks on Add to Wishlist btn
Then product is added to wishlist page
Then delete added item from wishlist

Scenario:  Add product to the wishlist and clear wishlist.
Given product details page url 'http://rozetka.com.ua/apple_macbook_air_zorj000n9/p2541567/' is opened
And wishlist is empty
When the user clicks on Add to Wishlist btn
Then product is added to wishlist
Then clear wishlist