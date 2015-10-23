package com.rozetka.steps;

import com.rozetka.pages.UserDetailsPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;

public class UserDetailsPageSteps extends ScenarioSteps {
	
	UserDetailsPage userDetails;
	
	@Step
	public void verifyThatWeOnTheUserDetailsPage(){
		assertThat("The User Details Page does not appear", userDetails.onPage());
	}

}
