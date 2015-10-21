package com.rozetka.pages;

import com.rozetka.panels.SearchPane;

import org.openqa.selenium.By;

public class UserDetailsPage extends SearchPane {
	
	private final By editProfileLink = By.cssSelector("a#edit_profile");
	
	public boolean onPage(){
		if(getElementBy(editProfileLink).isDisplayed()){
			return true;
		}else return false;
	}

}
