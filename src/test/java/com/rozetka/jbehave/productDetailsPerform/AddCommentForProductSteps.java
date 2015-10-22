package com.rozetka.jbehave.productDetailsPerform;
import org.jbehave.core.annotations.*;

import com.rozetka.steps.EndUserSteps;
import com.rozetka.steps.UserLoginLogoutModuleSteps;
import com.rozetka.steps.UserProductDetailsPageSteps;

import net.thucydides.core.annotations.Steps;
public class AddCommentForProductSteps{
	
	@Steps
	UserProductDetailsPageSteps userProdDetSteps;
	
	@Steps
	UserLoginLogoutModuleSteps userLoginSteps;
	
	
	@Given("the user opens a product details page")
	public void givenTheUserOpensAProductDetailsPage(){
		userProdDetSteps.openProductDetailsPage();
	}
	
	@Given("product is '$notebook' with '$size'")
	public void givenProductIsNotebookWith13(String notebook, String size){
		 userProdDetSteps.verifyProductHasParameters(notebook, size);
	}
	
	@When("the user '$name' with email '$email' add text '$text' to the comment field")
	public void whenTheUserAddtestCommentToTheCommentField(String name,String email,String text){
		 userProdDetSteps.addCommentForProduct(name, email, text);
	}
	
	@Then("the comment is added")
	public void thenCommentIsAddedToProducts(){
		 userProdDetSteps.addedCommentVerification();
	}	
	
}