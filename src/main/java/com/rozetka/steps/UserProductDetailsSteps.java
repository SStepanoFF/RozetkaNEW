package com.rozetka.steps;

import com.rozetka.pages.ProductDetailsPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserProductDetailsSteps extends ScenarioSteps {
	
	ProductDetailsPage productDetailsPage;
	
	@Step
	public void openProductDetailsPage(){
		productDetailsPage.openPDP();
	}
	
	@Step
	public void verifyProductHasParameters(String... parameters){
		assertThat("Product doesn't contains such parameters", productDetailsPage.doesProductHaveParametrs(parameters));
	}

}
