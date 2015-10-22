package com.rozetka.steps;

import com.rozetka.pages.SearchResultPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class UserSearchFilterPaneSteps extends ScenarioSteps {
	
	SearchResultPage searchResultPage;
	
	@Step
	public void selectCategory(String category){
		searchResultPage.selectCategory(category);
	}

}
