package com.rozetka.steps;

import com.rozetka.modules.Cart;
import com.rozetka.modules.SigninModule;
import com.rozetka.pages.MainPage;
import com.rozetka.pages.ProductDetailsPage;
import com.rozetka.pages.SearchResultPage;
import com.rozetka.pages.SigninPage;
import com.rozetka.pages.UserDetailsPage;
import com.rozetka.panels.SearchPane;

import static org.hamcrest.MatcherAssert.assertThat;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


public class EndUserSteps extends ScenarioSteps {

	MainPage mainPage;
	Cart cart;
	SearchPane searchPane;
	SearchResultPage searchResultPage;
	SigninPage signinPage;
	ProductDetailsPage productDetailsPage;
	UserDetailsPage userDetails;
	
	String userName;
	String commentText;
	String searchTerm;
	
	
	@Step
	public void opens_rozetka_store(){
		mainPage.openMainPage();
	}
	
	public void tearDown(){
	}
	
	@Step
	public void lookFor(String searchTerm){
		this.searchTerm=searchTerm;
		searchPane.enterInToSearchBox(searchTerm);
		searchPane.clickSearch();
	}
	
	@Step
	public void verifyThatProfileLinkPresent(){
		assertThat("The profile link is not present", searchPane.isProfileLinkPresent());
	}
	
	@Step
	public void purchaseItem(){
		searchResultPage.purchaseItem(this.searchTerm);
	}
	
	@Step
	public void checkForItemInTheCart(){
		assertThat("The "+this.searchTerm.toString()+" does not exist in the cart", cart.itemExists(this.searchTerm));
	}
	
	@Step
	public void closeCart(){
		cart.closeCart();
	}
	
	@Step
	public void openCart(){
		searchPane.clickCart();
	}
	
	@Step
	public void openSigninPage(){
		signinPage.openSigninPage();
	}
	
	@Step
	public void enterUserName(String userName){
		signinPage.enterUserName(userName);
	}
	
	@Step
	public void enterPassword(String password){
		signinPage.enterPassword(password);
	}
	
	@Step
	public void clickSubmit(){
		signinPage.clickSubmit();
	}
	
//	@Step
//	public void verifyThatSigninModulePresent(){
//		assertThat("The Login form did not appear ", signinModule.isUniqueElementPresent());
//	}
//	
	@Step
	public void verifyThatWeOnTheUserDetailsPage(){
		assertThat("We are not on the user details page", userDetails.onPage());
	}
	
	@Step
	public void logoutFromProfile(){
		searchPane.clickOnProfileLink();
		searchPane.logoutProfile();
	}
	
	@Step
	public void verifyThatUserIsNOTLogin(){
		assertThat("User is logged in", searchPane.isSigninLinkPresent());
	}
	
	@Step
	public void openProductDetailsPage(){
		productDetailsPage.open();
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

	
	
}