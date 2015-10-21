package com.rozetka.jbehave;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.rozetka.steps.EndUserSteps;
import com.rozetka.utils.RWebDriver;

public class ThePurchasingSteps {

    @Steps
    EndUserSteps endUser;

    ///
    @Given("the user opens rozetka store")
    public void givenTheUserOpensRozetkaStrore(){
    	endUser.opens_rozetka_store();
    }
    
    @Given("the user looks for '$itemName'")
    public void givenTheUserLooksForItem(String itemName){
    	endUser.lookFor(itemName);
    }
    
    @When("the user buys the item")
    public void whenTheUserBuysTheItem(){
    	endUser.purchaseItem();
    }
    @Then("the item should exist in the cart")
    public void thenTheItemShouldExistInTheCart(){
    	endUser.checkForItemInTheCart();
    }
    
    @Then("the user closes cart")
    public void thenTheuserClosesCart(){
    	endUser.closeCart();
    }
    
//    @Given("the user opens login form")
//    public void givenTheUserOpensLoginForm(){
//    	endUser.openSigninModule();
//    	endUser.verifyThatSigninModulePresent();
//    }
//    
//    @When("the user enters username: '$username' and password '$password'")
//    public void whenTheUserEntersUsernameAndPassword(String userName, String password){
//    	endUser.enterUserName(userName);
//    	endUser.enterPassword(password);
//    }
//    
//    @Then("the user clicks on the submit button")
//    public void thenTheUserClicksOnTheSubmitButton(){
//    	endUser.clickSubmit();
//    }
//    
//    @Then("the profile link should be displayed")
//    public void thenTheProfileLinkShouldBeDisplayed(){
//    	endUser.verifyThatProfileLinkPresent();
//    }
    
}
