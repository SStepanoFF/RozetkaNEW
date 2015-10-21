package com.rozetka.pages;

import org.openqa.selenium.By;

import com.rozetka.panels.SearchPane;

public class WishlistPage extends SearchPane{
	
	private String prodTitle="";
	
	public WishlistPage(){}
	
//	public WishlistPage(String prodTitle){
//		this.prodTitle=prodTitle;
//	}
	
	private final By productTitle=By.xpath("//div[@class='g-i-tile-i-title']/a");
	private final By deleteProductBtn= By.className("wishlist-g-i-remove");
	
	public boolean isProductPresentAtWishlist(){
		return true;
	}

}
