package com.rozetka.pages;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class UserSearchPaneSteps extends ScenarioSteps{
	
	ProductDetailsPage productDetailsPage;
	
	@Step
	public boolean verifyIsWishlistEmpty(){
		return productDetailsPage.isWishListEmpty();
	}

}
