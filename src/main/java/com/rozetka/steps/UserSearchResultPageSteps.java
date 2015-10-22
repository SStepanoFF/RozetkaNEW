package com.rozetka.steps;

import com.rozetka.pages.SearchResultPage;
import com.rozetka.steps.Variables.Variables;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static com.rozetka.steps.Variables.Variables.getVariables;

import com.rozetka.pages.SearchResultPage;

public class UserSearchResultPageSteps extends ScenarioSteps {
	
	SearchResultPage searchResultPage;
	
	@Step
	public void purchaseTheItem(){
		searchResultPage.buyItem(Variables.searchTerm);
	}

}
