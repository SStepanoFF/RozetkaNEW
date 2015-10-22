package com.rozetka.steps;

import com.rozetka.pages.MainPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class UserMainPageSteps extends ScenarioSteps {
	
	MainPage mainPage;
	
	@Step
	public void opens_rozetka_store(){
		mainPage.openMainPage();
	}
	
	@Step
	public void openCart(){
		mainPage.clickCart();
	}

}
