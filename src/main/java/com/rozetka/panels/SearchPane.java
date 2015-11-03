package com.rozetka.panels;


import com.rozetka.pages.WishlistPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import com.rozetka.utils.AbstractContainer;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://my.rozetka.com.ua/profile/wishlists/")
public class SearchPane extends AbstractContainer {
	
	//Locators
	private final By searchBox = By.cssSelector("input[name=text]");
	private final By searchBtn = By.cssSelector("button[name=search-button]");
	private final By cartBtn = By.cssSelector("a.sprite-side.novisited.hub-i-link.hub-i-cart-link");
	private final By signinLink = By.cssSelector("a[name=signin]");
	private final By profileLink = By.cssSelector("a[name=profile]");
	private final By logoutBtn =By.cssSelector("a[name='signout']");
	private final By wishListBtn=By.xpath("//div[@id='wishlist']//a");
	private final By uniqElementWishlistPage=By.cssSelector("h1.float-lt");
	
	
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
		waitForElementBy(logoutBtn);
		clickElementBy(logoutBtn);
	}
	
	public boolean isSigninLinkPresent(){
		return containsElementBy(signinLink) && getElementBy(signinLink).isDisplayed();
	}
	
	public void openWishlist() {
//		waitForElementBy(wishListBtn);
		clickElementBy(wishListBtn);
		int k=0;
		while (!isElementVisible(uniqElementWishlistPage)){
			clickElementBy(wishListBtn);
			k++;
		}
		System.out.println("Count: "+k);
//		getDriver().navigate().to("https://my.rozetka.com.ua/profile/wishlists/");
	}
}
