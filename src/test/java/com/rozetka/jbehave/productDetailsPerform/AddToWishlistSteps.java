package com.rozetka.jbehave.productDetailsPerform;

import static org.hamcrest.MatcherAssert.assertThat;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.rozetka.pages.UserDetailsPage;
import com.rozetka.steps.UserLoginLogoutModuleSteps;
import com.rozetka.steps.UserProductDetailsPageSteps;
import com.rozetka.steps.UserSearchPaneSteps;
import com.rozetka.steps.UserWishlistSteps;

import net.thucydides.core.annotations.Steps;

public class AddToWishlistSteps {
	
	@Steps
	UserProductDetailsPageSteps userProdDetSteps;
	
	@Steps
	UserLoginLogoutModuleSteps userLoginSteps;
	
	@Steps
	UserWishlistSteps userWishlistSteps;
	
	@Steps
	UserSearchPaneSteps userSearchPaneSteps;
	
	@Given("product details page is opened")
	public void givenTheUserOpensAProductDetailsPage(){
		userProdDetSteps.openProductDetailsPage();
	}
	
	@Given ("the user '$userName' with password '$password' login to rozetka store")
	public void givenUserIsLoginToRozetkaStore(String userName, String password){
		userLoginSteps.openSigninModule();
		userLoginSteps.login(userName, password);
		userLoginSteps.verifyThatProfileLinkPresent();
	}
	
	@Given("wishlist is empty")
	public void givenWishlistIsEmpty(){
		 if(!userSearchPaneSteps.isWishlistEmpty()){
			 userSearchPaneSteps.openWishlistPage();
			 userWishlistSteps.clearWishlist();
			 userWishlistSteps.verifyIsWishlistEmpty();
			 userProdDetSteps.openProductDetailsPage();
		 }
	}
	
	@When("the user clicks on Add to Wishlist btn")
	public void whenTheUserClicksOnAddToWishlist(){
		 userProdDetSteps.addToWishlist();
	}
	
	@Then("product is added to wishlist")
	public void thenATheOutcomeShouldBeCaptured(){
		 userProdDetSteps.verifyWishIsAddedOnProductPage(); 
	}
	
	@Then ("clear wishlist")
	public void thenClearWishlist(){
		if(!userSearchPaneSteps.isWishlistEmpty()){
			 userSearchPaneSteps.openWishlistPage();
			 userWishlistSteps.clearWishlist();
		}
		userSearchPaneSteps.verifyIsWishlistEmpty();
	}
}
