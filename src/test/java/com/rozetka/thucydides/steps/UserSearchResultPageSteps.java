package com.rozetka.thucydides.steps;

import com.rozetka.pages.SearchResultPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static com.rozetka.thucydides.steps.Variables.Variables.getVariables;

import com.rozetka.pages.SearchResultPage;

public class UserSearchResultPageSteps extends ScenarioSteps {
	
	SearchResultPage searchResultPage;
	
	@Step
	public void purchaseTheItem(){
		searchResultPage.buyItem(getVariables().searchTerm, getVariables().additionalSearchCriteria);
	}
	
	@Step
	public void goToItemDetailsPage(){
		searchResultPage.goToItemPage(getVariables().searchTerm, getVariables().additionalSearchCriteria);
	}

}
