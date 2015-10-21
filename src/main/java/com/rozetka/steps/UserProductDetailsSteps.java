package com.rozetka.steps;

import com.rozetka.pages.ProductDetailsPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserProductDetailsSteps extends ScenarioSteps {
	
	ProductDetailsPage productDetailsPage;
	
	String userName;
	String commentText;
	
	@Step
	public void openProductDetailsPage(){
		productDetailsPage.openProdDetailsPage();
	}
	
	@Step
	public void verifyProductHasParameters(String... parameters){
		assertThat("Product doesn't contains such parameters", productDetailsPage.isProductHaveParametrs(parameters));
	}
	
	@Step
	public void addCommentForProduct(String name, String email, String text) {
		this.userName=name;
		this.commentText=text;
		productDetailsPage.addComment(name, email, text);
		
	}
	
	@Step
	public void addedCommentVerification(){
		assertThat("Comment was not added",productDetailsPage.isCommentAdded(this.commentText, this.userName));
	}

	

}
