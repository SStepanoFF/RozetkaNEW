package com.rozetka.thucydides.steps;

import com.rozetka.pages.MainPage;
import com.rozetka.pages.ProductDetailsPage;
import com.rozetka.panels.SearchPane;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static com.rozetka.thucydides.steps.Variables.Variables.getValue;
import static com.rozetka.thucydides.steps.Variables.Variables.putValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserSearchPaneSteps extends ScenarioSteps{
	
	MainPage mainPage;
	ProductDetailsPage productDetailsPage;
	SearchPane searchPane;
	
	
	
	@Step
	public void lookFor(String searchTerm, String additionalSearchCriteria){
		putValue("additionalSearchCriteria", additionalSearchCriteria);
		putValue("searchTerm", searchTerm);
		mainPage.enterInToSearchBox(searchTerm+" "+additionalSearchCriteria);
		mainPage.clickSearch();
	}
	
	@Step
	public void verifyIsWishlistEmpty(){
		assertThat("Wishlist is not empty", productDetailsPage.isWishListEmpty());
	}
	
	@Step
	public boolean isWishlistEmpty(){
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
