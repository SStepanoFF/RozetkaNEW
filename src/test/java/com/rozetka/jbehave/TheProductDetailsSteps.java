package com.rozetka.jbehave;
import org.jbehave.core.annotations.*;

import com.rozetka.steps.EndUserSteps;
import com.rozetka.steps.UserProductDetailsSteps;

import net.thucydides.core.annotations.Steps;
public class TheProductDetailsSteps{
	
	@Steps
	EndUserSteps userSteps;
	
	
	@Given("the user opens a product details page")
	public void givenTheUserOpensAProductDetailsPage(){
		 userSteps.openProductDetailsPage();
	}
	
	@Given("product is '$notebook' with '$size'")
	public void givenProductIsNotebookWith13(String notebook, String size){
		 userSteps.verifyProductHasParameters(notebook, size);
	}
	
	@When("the user '$name' with email '$email' add text '$text' to the comment field")
	public void whenTheUserAddtestCommentToTheCommentField(String name,String email,String text){
		 userSteps.addCommentForProduct(name, email, text);
	}
	
	@Then("comment is added to product")
	public void thenCommentIsAddedToProduct(){
		 userSteps.addedCommentVerification();
	}
	
	
	@Given("wishlist btn is available")
	@Pending
	public void givenWishlistBtnIsAvailable(){
		 //TODO 
	}
	
	@When("the user clicks on Add to Wishlist btn")
	@Pending
	public void whenTheUserClicksOnAddToWishlist(){
		 //TODO 
	}
	
	@Then("product is added to wishlist")
	@Pending
	public void thenATheOutcomeShouldBeCaptured(){
		 //TODO 
	}
	
	
}