package com.rozetka.steps;

import com.rozetka.pages.WishlistPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class UserWishlistSteps extends ScenarioSteps{
	
	WishlistPage wishPage;
	
	@Step
	public void clearWishlist(){
		wishPage.deleteAllWishes();
	}
	
}
