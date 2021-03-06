package com.rozetka.thucydides.steps;

import static org.hamcrest.MatcherAssert.assertThat;

import com.rozetka.modules.Cart;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static com.rozetka.thucydides.steps.Variables.Variables.getValue;
import static com.rozetka.thucydides.steps.Variables.Variables.putValue;

public class UserCartSteps extends ScenarioSteps {
	
	Cart cart;
	
	
	@Step
	public void checkIsCartDisplayed(){
		assertThat("The cart did not appear", cart.onPage());
	}
	
	@Step
	public void checkForItemInTheCart(){
		assertThat("The "+getValue("searchTerm")+" does not exist in the cart", cart.isItemInTheCart(getValue("searchTerm")));
	}
	
	@Step
	public void checkPositionOfTheItemInTheCart(String itemName, String expectedPosition){
	
		String name=null;
		
		if(itemName==null){
			name=getValue("searchTerm");
		}else {
			name=itemName;
		}
		
		Integer itemPosition=cart.getItemPositionInTheCart(name);
		
		if(itemPosition==0){
				assertThat("The item: "+name+ " is not present in the cart", false);
		}else {
			assertThat("The position of the: "+name+" in the cart is: "+itemPosition+" , but should be: "+expectedPosition, expectedPosition.equals(itemPosition.toString()));
		}
	}
	
	@Step
	public void closeCart(){
		cart.closeCart();
	}
	

}
