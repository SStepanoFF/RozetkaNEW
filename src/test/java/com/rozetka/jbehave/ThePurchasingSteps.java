package com.rozetka.jbehave;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.rozetka.steps.EndUserSteps;
import com.rozetka.steps.UserPurchasingSteps;

public class ThePurchasingSteps {

    @Steps
    UserPurchasingSteps userPurchasing;
    EndUserSteps endUser;

    ///
    @Given("the user opens rozetka store")
    public void givenTheUserOpensRozetkaStrore(){
    	userPurchasing.opens_rozetka_store();
    }
    
    @Given("the user looks for '$itemName'")
    public void givenTheUserLooksForItem(String itemName){
    	userPurchasing.lookFor(itemName);
    }
    
    @Then("the user selects the '$categoryName' category")
    public void thenTheUserSelectsTheCategory(String category){
    		userPurchasing.selectCategory(category);
    }
    
    @When("the user buys the item")
    @Then("the user buys the item")
    public void whenTheUserBuysTheItem(){
    	userPurchasing.purchaseTheItem();
    }
    
    @When("cart appeared")
    @Then("cart should appear")
    public void whenTheCartAppears(){
    	userPurchasing.checkIsCartDisplayed();
    }
    
    @Then("the item should exist in the cart")
    public void thenTheItemShouldExistInTheCart(){
    	userPurchasing.checkForItemInTheCart();
    }
    
    @Then("the user closes cart")
    public void thenTheuserClosesCart(){
    	userPurchasing.closeCart();
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
