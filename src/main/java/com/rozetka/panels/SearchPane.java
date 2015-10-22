package com.rozetka.panels;

import org.openqa.selenium.By;

import com.rozetka.utils.AbstractContainer;

import net.serenitybdd.core.pages.PageObject;

public class SearchPane extends AbstractContainer {
	
	//Locators
	private final By searchBox = By.cssSelector("input[name=text]");
	private final By searchBtn = By.cssSelector("button[name=search-button]");
	private final By cartBtn = By.cssSelector("a.sprite-side.novisited.hub-i-link.hub-i-cart-link");
	private final By signinLink = By.cssSelector("a[name=signin]");
	private final By profileLink = By.cssSelector("a[name=profile]");
	private final By logoutBtn =By.cssSelector("a[name='signout']");
	private final By wishListBtn=By.id("wishlist-header");
	
	
	public void enterInToSearchBox(String searchItem){
		enterValueInTo(searchBox, searchItem);
	}
	
	public void clickSearch(){
		clickElementBy(searchBtn);
	}
	
	public void clickCart(){
		clickElementBy(cartBtn);
	}

	public void openSigninModule(){
		clickElementBy(signinLink);
	}
	
	public boolean isProfileLinkPresent(){
		return containsElementBy(profileLink) && getElementBy(profileLink).isDisplayed();
	}
	
	public void clickOnProfileLink(){
		clickElementBy(profileLink);
	}
	
	public void logoutProfile(){
		clickElementBy(logoutBtn);
	}
	
	public boolean isSigninLinkPresent(){
		return containsElementBy(signinLink) && getElementBy(signinLink).isDisplayed();
	}
	
	public void openWishlist(){
//		getElementBy(wishListBtn).click();
		clickElementBy(wishListBtn);
	}
}
