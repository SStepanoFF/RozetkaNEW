package com.rozetka.steps;

import static org.hamcrest.MatcherAssert.assertThat;

import com.rozetka.modules.SigninModule;
import com.rozetka.pages.MainPage;
import com.rozetka.panels.SearchPane;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginLogoutSteps extends ScenarioSteps{
	
	MainPage mainPage;
	SearchPane searchPane;
	SigninModule signinModule;
	
	@Step
	public void opens_rozetka_store(){
		mainPage.open();
	}
	
	@Step
	public void openSigninModule(){
		searchPane.openSigninModule();
	}
	
	@Step
	public void enterUserName(String userName){
		signinModule.enterUserName(userName);
	}
	
	@Step
	public void enterPassword(String password){
		signinModule.enterPassword(password);
	}
	
	@Step
	public void clickSubmit(){
		signinModule.clickSubmit();
	}
	
	@Step
	public void verifyThatSigninModulePresent(){
		assertThat("The Login form did not appear ", signinModule.isUniqueElementPresent());
	}
	
	@Step
	public void verifyThatProfileLinkPresent(){
		assertThat("The profile link does not display", searchPane.isProfileLinkPresent());
	}
	
	@Step
	public void logoutFromProfile(){
		searchPane.logoutProfile();
	}
	
	@Step
	public void verifyThatUserIsNOTLogin(){
		assertThat("User is logged in", searchPane.isSigninLinkPresent());
	}

}
