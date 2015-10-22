package com.rozetka.steps;

import static org.hamcrest.MatcherAssert.assertThat;

import com.rozetka.modules.Cart;
import com.rozetka.pages.MainPage;
import com.rozetka.pages.SearchResultPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class UserPurchasingSteps extends ScenarioSteps {
	
	SearchResultPage searchResultPage;
	MainPage mainPage;
	Cart cart;
	
	//Variables
	String searchTerm;
	
	@Step
	public void opens_rozetka_store(){
		mainPage.openMainPage();
	}
	
	
	@Step
	public void lookFor(String searchTerm){
		this.searchTerm=searchTerm;
		mainPage.enterInToSearchBox(searchTerm);
		mainPage.clickSearch();
	}
	
	@Step
	public void selectCategory(String category){
		searchResultPage.selectCategory(category);
	}
	
	@Step
	public void purchaseTheItem(){
		searchResultPage.buyItem(this.searchTerm);
	}
	
	@Step
	public void checkIsCartDisplayed(){
		assertThat("The cart did not appear", cart.onPage());
	}
	
	@Step
	public void checkForItemInTheCart(){
		assertThat("The "+this.searchTerm.toString()+" does not exist in the cart", cart.itemExists(this.searchTerm));
	}
	
	@Step
	public void openCart(){
		mainPage.clickCart();
	}
	
	@Step
	public void closeCart(){
		cart.closeCart();
	}
	
	

}
