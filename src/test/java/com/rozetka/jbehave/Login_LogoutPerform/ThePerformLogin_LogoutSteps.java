package com.rozetka.jbehave.Login_LogoutPerform;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


import com.rozetka.thucydides.steps.UserDetailsPageSteps;
import com.rozetka.thucydides.steps.UserMainPageSteps;
import com.rozetka.thucydides.steps.UserSearchPaneSteps;
import com.rozetka.thucydides.steps.UserSigninPageSteps;

import net.thucydides.core.annotations.Steps;

public class ThePerformLogin_LogoutSteps{
	 
	@Steps
	UserMainPageSteps mainPage;
	@Steps
	UserSigninPageSteps signinPage;
	@Steps
	UserDetailsPageSteps userDetails;
	@Steps
	UserSearchPaneSteps searchPane;
	
	
	@Given("the user opens rozetka")
	    public void givenTheUserOpensRozetkaStrore(){
		mainPage.opens_rozetka_store();
	    }
	
	@Given("the user opens login page")
	public void givenTheUserOpensLoginPage(){
		signinPage.opensSigninPage();
	}
	
	    
	    @When("the user enters username: '$username' and password '$password'")
	    public void whenTheUserEntersUsernameAndPassword(String userName, String password){
	    	signinPage.enterUserName(userName);
	    	signinPage.enterPassword(password);
	    }
	    
	    @Then("the user clicks on the submit button")
	    public void thenTheUserClicksOnTheSubmitButton(){
	    	signinPage.clickSubmit();
	    }
	    
	    @Then("the user should be redirected to the user details page")
	    public void thenTheUserShouldBeRedirectedToTheUserDetailsPage(){
	    	userDetails.verifyThatWeOnTheUserDetailsPage();
	    }
	    
	    @Given ("the user is logged in")
	    public void givenTheUserIsLoggedIn(){
	    	searchPane.verifyThatProfileLinkPresent();
	    }
	    
	    @When ("the user clicks logOut btn")
	    public void whenTheUserClickLogOutBtn(){
	    	searchPane.logoutFromProfile();
	    }
	    
	    @Then ("the sign link should be displayed")
	    public void thenTheSignLinkShouldBeDisplayed(){
	    	searchPane.verifyThatUserIsNOTLogin();
	    }
	    
//	    @Given("the user logins with these credentials: '$userName' as username and '$password' as password")
//	    public void givenTheUserLoginsWithTheseCredentials(String userName, String password){
//	    	givenTheUserOpensLoginForm();
//	    	whenTheUserEntersUsernameAndPassword(userName, password);
//	    	thenTheUserClicksOnTheSubmitButton();
//	    	thenTheProfileLinkShouldBeDisplayed();
//	    }
}