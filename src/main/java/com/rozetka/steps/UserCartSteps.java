package com.rozetka.steps;

import static org.hamcrest.MatcherAssert.assertThat;

import com.rozetka.modules.Cart;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class UserCartSteps extends ScenarioSteps {
	
	Cart cart;
	
	
	@Step
	public void checkIsCartDisplayed(){
		assertThat("The cart did not appear", cart.onPage());
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
