package com.rozetka.pages;

import org.openqa.selenium.By;

import com.rozetka.utils.AbstractContainer;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://my.rozetka.com.ua/signin/")
public class SigninPage extends AbstractContainer {
	private final By userNameField = By.cssSelector("input[name=login]");
	private final By passwordField = By.cssSelector("input[name=password]");
	private final By submitBtn = By.cssSelector("button[type=submit]");
	
//	
//	@Override
//	public String getBaseUrl(){
//		return null;
//	}
//	
//	@Override
//	public By getUniqueElement(){
//		return submitBtn;
//	}
	
	public void enterUserName(String userName){
		enterValueInTo(userNameField, userName);
	}
	
	public void enterPassword(String password){
		enterValueInTo(passwordField, password);
	}
	
	public void clickSubmit(){
		clickElementBy(submitBtn);
	}
	
	public void openSigninPage(){
		open();
	}
	
}
