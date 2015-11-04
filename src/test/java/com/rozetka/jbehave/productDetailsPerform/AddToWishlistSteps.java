package com.rozetka.jbehave.productDetailsPerform;

import static org.hamcrest.MatcherAssert.assertThat;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.rozetka.pages.UserDetailsPage;
import com.rozetka.thucydides.steps.UserLoginLogoutModuleSteps;
import com.rozetka.thucydides.steps.UserProductDetailsPageSteps;
import com.rozetka.thucydides.steps.UserSearchPaneSteps;
import com.rozetka.thucydides.steps.UserWishlistSteps;
import static com.rozetka.thucydides.steps.Variables.Variables.getValue;
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
	
	private String url;
	
	@Given("product details page url '$url' is opened")
	public void givenTheUserOpensAProductDetailsPage(String url){
		this.url=url;
		userProdDetSteps.openProductDetailsPage(url);
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
			 userProdDetSteps.openProductDetailsPage(url);
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

	@Then ("product is added to wishlist page")
	public void thenProductIsAddedToWishlistPage(){
		userSearchPaneSteps.openWishlistPage();
		assertThat(getValue("prodTitle")+" was not added", userWishlistSteps.isWishPresent(getValue("prodTitle")));
	}

	@Then ("delete added item from wishlist")
	public void thenDeleteAddedItemFromWishlist(){
		userWishlistSteps.deleteSindleWish(getValue("prodTitle"));
		assertThat(getValue("prodTitle")+" is not deleted", !userWishlistSteps.isWishPresent(getValue("prodTitle")));
	}
}
