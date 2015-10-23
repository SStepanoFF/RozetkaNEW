package com.rozetka.steps;

import com.rozetka.pages.SigninPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class UserSigninPageSteps extends ScenarioSteps {
	
	SigninPage signinPage;
	
	@Step
	public void opensSigninPage(){
		signinPage.openSigninPage();
		
	}
	
	@Step
	public void enterUserName(String userName){
		signinPage.enterUserName(userName);
	}
	
	@Step
	public void enterPassword(String password){
		signinPage.enterPassword(password);
	}
	
	@Step
	public void clickSubmit(){
		signinPage.clickSubmit();
	}

}
