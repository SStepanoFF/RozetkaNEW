package com.rozetka.pages;

import org.openqa.selenium.By;

import com.rozetka.panels.SearchPane;

import net.serenitybdd.core.pages.WebElementFacade;

public class WishlistPage extends SearchPane{
	
	private String prodTitle="";
	
	private final By productTitle=By.xpath("//div[@class='g-i-tile-i-title']/a");
	private final By deleteSingleWishBtn= By.className("wishlist-g-i-remove");
	private final By checkWish= By.cssSelector("label[class='wishlist-g-i-check']");
	private final By deleteWishBtn =By.cssSelector("a[name='wishlist-block-price-delete']");
	private final By emptyWishlistMess=By.xpath("//section[@class='wishlist-i']//h3[@class='wishlist-i-empty-title']");
	
	public boolean isWishesPresent(){
		if (containsElementBy(deleteSingleWishBtn) && !containsElementBy(emptyWishlistMess)){
			return true;
		}else return false;
	}
	
	public void deleteAllWishes(){
		if (isWishesPresent()){
			for (WebElementFacade elem: getAllElementsBy(deleteSingleWishBtn)){
				clickOn(elem);
			}
			waitForElementBy(emptyWishlistMess);
		}
	}

}
