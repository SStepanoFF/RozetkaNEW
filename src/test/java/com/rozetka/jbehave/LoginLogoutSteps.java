package com.rozetka.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.rozetka.steps.UserLoginLogoutSteps;

import net.thucydides.core.annotations.Steps;

public class LoginLogoutSteps{
	 
	@Steps
    UserLoginLogoutSteps loginLogoutSteps;
	
	 @Given("the user opens rozetka")
	    public void givenTheUserOpensRozetkaStrore(){
		 loginLogoutSteps.opens_rozetka_store();
	    }
	
	@Given("the user opens login form")
	    public void givenTheUserOpensLoginForm(){
		loginLogoutSteps.openSigninModule();
		loginLogoutSteps.verifyThatSigninModulePresent();
	    }
	    
	    @When("the user enters username: '$username' and password '$password'")
	    public void whenTheUserEntersUsernameAndPassword(String userName, String password){
	    	loginLogoutSteps.enterUserName(userName);
	    	loginLogoutSteps.enterPassword(password);
	    }
	    
	    @Then("the user clicks on the submit button")
	    public void thenTheUserClicksOnTheSubmitButton(){
	    	loginLogoutSteps.clickSubmit();
	    }
	    
	    @Then("the profile link should be displayed")
	    public void thenTheProfileLinkShouldBeDisplayed(){
	    	loginLogoutSteps.verifyThatProfileLinkPresent();
	    }
	    
	    @Given ("the user is logged in")
	    public void givenTheUserIsLoggedIn(){
	    	loginLogoutSteps.verifyThatProfileLinkPresent();
	    }
	    
	    @When ("the user clicks logOut btn")
	    public void whenTheUserClickLogOutBtn(){
	    	loginLogoutSteps.logoutFromProfile();
	    }
	    
	    @Then ("the sign link should be displayed")
	    public void thenTheSignLinkShouldBeDisplayed(){
	    	loginLogoutSteps.verifyThatUserIsNOTLogin();
	    }
	    
//	    @Given("the user logins with these credentials: '$userName' as username and '$password' as password")
//	    public void givenTheUserLoginsWithTheseCredentials(String userName, String password){
//	    	givenTheUserOpensLoginForm();
//	    	whenTheUserEntersUsernameAndPassword(userName, password);
//	    	thenTheUserClicksOnTheSubmitButton();
//	    	thenTheProfileLinkShouldBeDisplayed();
//	    }
}