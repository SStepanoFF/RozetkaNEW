package com.rozetka.steps;

import com.rozetka.pages.MainPage;
import com.rozetka.pages.ProductDetailsPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class UserSearchPaneSteps extends ScenarioSteps{
	
	MainPage mainPage;
	ProductDetailsPage productDetailsPage;
	
	@Step
	public void lookFor(String searchTerm){
		this.searchTerm=searchTerm;
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

}
