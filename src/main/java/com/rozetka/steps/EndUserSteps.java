package com.rozetka.steps;

import com.rozetka.modules.Cart;
import com.rozetka.modules.SigninModule;
import com.rozetka.pages.MainPage;
import com.rozetka.pages.SearchResultPage;
import com.rozetka.panels.SearchPane;

import static org.hamcrest.MatcherAssert.assertThat;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


public class EndUserSteps extends ScenarioSteps {

	MainPage mainPage;
	Cart cart;
	SearchPane searchPane;
	SearchResultPage searchResultPage;
	SigninModule signinModule;
	
	String searchTerm;
	
	
	@Step
	public void opens_rozetka_store(){
		mainPage.open();
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
	
	
}