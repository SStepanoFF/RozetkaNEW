package com.rozetka.modules;

import org.openqa.selenium.By;

import com.rozetka.utils.AbstractContainer;

public class SigninModule extends AbstractContainer {
	private final By userNameField = By.cssSelector("input[name=login]");
	private final By passwordField = By.cssSelector("input[name=password]");
	private final By submitBtn = By.cssSelector("button[name=auth_submit]");
	private final By title = By.cssSelector("h5.auth-title");
	private final By socialNetworksVessage= By.xpath("//a[@class='social-bind-tiny-close novisited']");
	
	public void enterUserName(String userName){
		clearFieldBy(userNameField);
		enterValueInTo(userNameField, userName);
	}
	
	public void enterPassword(String password){
		enterValueInTo(passwordField, password);
	}
	
	public void clickSubmit(){
		clickElementBy(submitBtn);
		if (containsElementBy(socialNetworksVessage)){
			clickElementBy(socialNetworksVessage);
		}
	}
	
	public boolean isUniqueElementPresent(){
		if(getElementBy(title)!=null){
		return getElementBy(title).isDisplayed();
		}
		else return false;
	}


}
