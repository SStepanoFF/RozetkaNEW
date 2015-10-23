package com.rozetka.steps;

import com.rozetka.pages.MainPage;
import com.rozetka.pages.ProductDetailsPage;
import com.rozetka.panels.SearchPane;
import com.rozetka.steps.Variables.Variables;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static com.rozetka.steps.Variables.Variables.getVariables;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserSearchPaneSteps extends ScenarioSteps{
	
	MainPage mainPage;
	ProductDetailsPage productDetailsPage;
	SearchPane searchPane;
	
	
	
	@Step
	public void lookFor(String searchTerm){
		getVariables().searchTerm=searchTerm;
		mainPage.enterInToSearchBox(searchTerm);
		mainPage.clickSearch();
	}
	
	@Step
	public boolean verifyIsWishlistEmpty(){
		return productDetailsPage.isWishListEmpty();
	}
	
	@Step
	public void openWishlistPage(){
		productDetailsPage.openWishlist();
	}
	
	@Step
	public void verifyThatProfileLinkPresent(){
		assertThat("The profile link is not present", searchPane.isProfileLinkPresent());
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
}
