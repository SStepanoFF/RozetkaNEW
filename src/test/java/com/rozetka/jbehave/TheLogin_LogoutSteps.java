package com.rozetka.jbehave;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.rozetka.steps.EndUserSteps;
import com.rozetka.utils.RWebDriver;

import net.thucydides.core.annotations.Steps;

public class TheLogin_LogoutSteps{
	 
	@Steps
	EndUserSteps endUser;
	
	
	@Given("the user opens rozetka")
	    public void givenTheUserOpensRozetkaStrore(){
		endUser.opens_rozetka_store();
	    }
	
	@Given("the user opens login page")
	public void givenTheUserOpensLoginPage(){
		endUser.openSigninPage();
	}
	
	    
	    @When("the user enters username: '$username' and password '$password'")
	    public void whenTheUserEntersUsernameAndPassword(String userName, String password){
	    	endUser.enterUserName(userName);
	    	endUser.enterPassword(password);
	    }
	    
	    @Then("the user clicks on the submit button")
	    public void thenTheUserClicksOnTheSubmitButton(){
	    	endUser.clickSubmit();
	    }
	    
	    @Then("the user should be redirected to the user details page")
	    public void thenTheUserShouldBeRedirectedToTheUserDetailsPage(){
	    	endUser.verifyThatWeOnTheUserDetailsPage();
	    }
	    
	    @Given ("the user is logged in")
	    public void givenTheUserIsLoggedIn(){
	    	endUser.verifyThatProfileLinkPresent();
	    }
	    
	    @When ("the user clicks logOut btn")
	    public void whenTheUserClickLogOutBtn(){
	    	endUser.logoutFromProfile();
	    }
	    
	    @Then ("the sign link should be displayed")
	    public void thenTheSignLinkShouldBeDisplayed(){
	    	endUser.verifyThatUserIsNOTLogin();
	    }
	    
//	    @Given("the user logins with these credentials: '$userName' as username and '$password' as password")
//	    public void givenTheUserLoginsWithTheseCredentials(String userName, String password){
//	    	givenTheUserOpensLoginForm();
//	    	whenTheUserEntersUsernameAndPassword(userName, password);
//	    	thenTheUserClicksOnTheSubmitButton();
//	    	thenTheProfileLinkShouldBeDisplayed();
//	    }
}