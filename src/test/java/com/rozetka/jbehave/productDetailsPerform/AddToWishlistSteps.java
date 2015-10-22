package com.rozetka.jbehave.productDetailsPerform;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.rozetka.pages.UserDetailsPage;
import com.rozetka.steps.UserLoginLogoutModuleSteps;
import com.rozetka.steps.UserProductDetailsPageSteps;

import net.thucydides.core.annotations.Steps;

public class AddToWishlistSteps {
	
	@Steps
	UserProductDetailsPageSteps userProdDetSteps;
	
	@Steps
	UserLoginLogoutModuleSteps userLoginSteps;
	
	@Given("product details page is opened")
	public void givenTheUserOpensAProductDetailsPage(){
		userProdDetSteps.openProductDetailsPage();
	}
	
	@Given("wishlist is empty")
	public void givenWishlistIsEmpty(){
		 if(userProdDetSteps.verifyIsWishlistEmpty()){}
	}
	
	@Given ("the user '$userName' with password '$password' login to rozetka store")
	public void givenUserIsLoginToRozetkaStore(String userName, String password){
		userLoginSteps.openSigninModule();
		userLoginSteps.login(userName, password);
		userLoginSteps.verifyThatProfileLinkPresent();
	}
	
	@When("the user clicks on Add to Wishlist btn")
	public void whenTheUserClicksOnAddToWishlist(){
		 userProdDetSteps.addToWishlist();
	}
	
	@Then("product is added to wishlist")
	public void thenATheOutcomeShouldBeCaptured(){
		 userProdDetSteps.verifyWishIsAddedOnProductPage(); 
	}
}