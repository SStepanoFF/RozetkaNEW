package com.rozetka.jbehave.PurchasingPerform;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.rozetka.steps.UserCartSteps;
import com.rozetka.steps.UserMainPageSteps;
import com.rozetka.steps.UserSearchFilterPaneSteps;
import com.rozetka.steps.UserSearchPaneSteps;
import com.rozetka.steps.UserSearchResultPageSteps;

public class ThePerformPurchasingSteps {

    @Steps
    UserMainPageSteps mainPage;
    @Steps
    UserSearchPaneSteps searchPane;
    @Steps
    UserSearchFilterPaneSteps searchFilter;
    @Steps
    UserSearchResultPageSteps searchResult;
    @Steps
    UserCartSteps cart;

    ///
    @Given("the user opens rozetka store")
    public void givenTheUserOpensRozetkaStrore(){
    	mainPage.opens_rozetka_store();
    }
    
    @Given("the user looks for '$itemName'")
    public void givenTheUserLooksForItem(String itemName){
    	searchPane.lookFor(itemName);
    }
    
    @Then("the user selects the '$categoryName' category")
    public void thenTheUserSelectsTheCategory(String category){
    	searchFilter.selectCategory(category);
    }
    
    @When("the user buys the item")
    @Then("the user buys the item")
    public void whenTheUserBuysTheItem(){
    	searchResult.purchaseTheItem();
    }
    
    @When("cart appeared")
    @Then("cart should appear")
    public void whenTheCartAppears(){
    	cart.checkIsCartDisplayed();
    }
    
    @Then("the item should exist in the cart")
    public void thenTheItemShouldExistInTheCart(){
    	cart.checkForItemInTheCart();
    }
    
    @Then("the user closes cart")
    public void thenTheuserClosesCart(){
    	cart.closeCart();
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
