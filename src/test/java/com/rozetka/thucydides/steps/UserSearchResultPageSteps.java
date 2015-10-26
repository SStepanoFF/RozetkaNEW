package com.rozetka.thucydides.steps;

import com.rozetka.pages.SearchResultPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static com.rozetka.thucydides.steps.Variables.Variables.getValue;
import static com.rozetka.thucydides.steps.Variables.Variables.putValue;

import com.rozetka.pages.SearchResultPage;

public class UserSearchResultPageSteps extends ScenarioSteps {
	
	SearchResultPage searchResultPage;
	
	@Step
	public void purchaseTheItem(){
		searchResultPage.buyItem(getValue("searchTerm"), getValue("additionalSearchCriteria"));
	}
	
	@Step
	public void goToItemDetailsPage(){
		searchResultPage.goToItemPage(getValue("searchTerm"), getValue("additionalSearchCriteria"));
	}

}
