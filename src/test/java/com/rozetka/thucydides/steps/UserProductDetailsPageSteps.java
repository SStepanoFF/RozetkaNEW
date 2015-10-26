package com.rozetka.thucydides.steps;

import com.rozetka.pages.ProductDetailsPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserProductDetailsPageSteps extends ScenarioSteps {
	
	ProductDetailsPage productDetailsPage;
	
	String userName;
	String commentText;
	
	@Step
	public void buyItemFromDetailsPage(){
		productDetailsPage.clickBuy();
	}
	
	@Step
	public void openProductDetailsPage(String url){
		productDetailsPage.openProdDetailsPage(url);
	}
	
	@Step
	public void verifyProductHasParameters(String... parameters){
		assertThat("Product doesn't contains such parameters", productDetailsPage.isProductHaveParametrs(parameters));
	}
	
	@Step
	public void addCommentForProduct(String name, String email, String text) {
		this.userName=name;
		this.commentText=text;
		productDetailsPage.addComment(name, email, text);
		
	}
	
	@Step
	public void addedCommentVerification(){
		assertThat("Comment was not added",productDetailsPage.isCommentAdded(this.commentText, this.userName));
	}
	
	@Step
	public void verificationAddToWishlistBtnIsDisplayed(){
		assertThat("Wishlist btn does not display", productDetailsPage.isWishlistBtnAvailable());
	}
	
	@Step
	public void addToWishlist(){
		productDetailsPage.addToWishlist();
	}
	
	@Step
	public void verifyWishIsAddedOnProductPage(){
		assertThat("Product is not added to wishlist",productDetailsPage.isProductAddedToWishlist());
	}
	
	@Step
	public void checkIfUserOnTheProductDetailsPage(){
		assertThat("The product details page did not appear", productDetailsPage.onPage());
	}

	

}
