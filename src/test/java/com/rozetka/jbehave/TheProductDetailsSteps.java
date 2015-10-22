package com.rozetka.jbehave;
import org.jbehave.core.annotations.*;

import com.rozetka.steps.EndUserSteps;
import com.rozetka.steps.UserLoginLogoutModuleSteps;
import com.rozetka.steps.UserProductDetailsSteps;

import net.thucydides.core.annotations.Steps;
public class TheProductDetailsSteps{
	
	@Steps
	UserProductDetailsSteps userProdDetSteps;
	UserLoginLogoutModuleSteps userLoginSteps;
	
	
	@Given("the user opens a product details page")
	public void givenTheUserOpensAProductDetailsPage(){
		userProdDetSteps.openProductDetailsPage();
	}
	
	@Given("product is '$notebook' with '$size'")
	public void givenProductIsNotebookWith13(String notebook, String size){
		 userProdDetSteps.verifyProductHasParameters(notebook, size);
	}
	
	@When("the user '$name' with email '$email' add text '$text' to the comment field")
	public void whenTheUserAddtestCommentToTheCommentField(String name,String email,String text){
		 userProdDetSteps.addCommentForProduct(name, email, text);
	}
	
	@Then("the comment is added")
	public void thenCommentIsAddedToProducts(){
		 userProdDetSteps.addedCommentVerification();
	}
	
	
	@Given("wishlist btn is available")
	public void givenWishlistBtnIsAvailable(){
		 userProdDetSteps.verificationAddToWishlistBtnIsDisplayed();
	}
	
	@Given ("the user '$userName' with password '$password' login to rozetka store")
	public void givenUserIsLoginToRozetkaStore(String userName, String password){
		userLoginSteps.openSigninModule();
		userLoginSteps.enterUserName(userName);
		userLoginSteps.enterPassword(password);
		userLoginSteps.verifyThatProfileLinkPresent();
	}
	
	@When("the user clicks on Add to Wishlist btn")
	public void whenTheUserClicksOnAddToWishlist(){
		 //TODO 
	}
	
	@Then("product is added to wishlist")
	@Pending
	public void thenATheOutcomeShouldBeCaptured(){
		 //TODO 
	}
	
	
}