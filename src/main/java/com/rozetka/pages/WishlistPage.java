package com.rozetka.pages;

import org.openqa.selenium.By;

import com.rozetka.panels.SearchPane;

import net.serenitybdd.core.pages.WebElementFacade;

public class WishlistPage extends SearchPane{
	
	private final By uniqElement=By.cssSelector("h1.float-lt");
	
	private final By productTitle=By.xpath("//div[@class='g-i-tile-i-title']/a");
	private final By deleteSingleWishBtn= By.className("wishlist-g-i-remove");
	private final By checkWish= By.cssSelector("label[class='wishlist-g-i-check']");
	private final By deleteWishBtn =By.cssSelector("a[name='wishlist-block-price-delete']");
	private final By emptyWishlistMess=By.xpath("//section[@class='wishlist-i']//h3[@class='wishlist-i-empty-title']");
	
	public boolean isPageOpened(){
		if(isElementVisible(uniqElement)){
			return true;
		}else return false;
	}

	public boolean isWishlistEmpty(){
		if (containsElementBy(deleteSingleWishBtn) && !containsElementBy(emptyWishlistMess)){
			return false;
		}else return true;
	}
	
	public void deleteAllWishes(){
		if (!isWishlistEmpty()){
			for (WebElementFacade elem: getAllElementsBy(deleteSingleWishBtn)){
				clickWebElement(elem);
			}
			waitForElementBy(emptyWishlistMess);
		}
	}

}
