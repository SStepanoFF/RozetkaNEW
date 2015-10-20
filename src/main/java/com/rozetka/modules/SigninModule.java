package com.rozetka.modules;

import org.openqa.selenium.By;

import com.rozetka.utils.AbstractContainer;

public class SigninModule extends AbstractContainer {
	private final By userNameField = By.cssSelector("input[name=login]");
	private final By passwordField = By.cssSelector("input[name=password]");
	private final By submitBtn = By.cssSelector("button[name=auth_submit]");
	private final By title = By.cssSelector("h5.auth-title");
	
	public void enterUserName(String userName){
		enterValueInTo(userNameField, userName);
	}
	
	public void enterPassword(String password){
		enterValueInTo(passwordField, password);
	}
	
	public void clickSubmit(){
		clickElementBy(submitBtn);
	}
	
	public boolean isUniqueElementPresent(){
		return getElementBy(title).isDisplayed();
	}

}
