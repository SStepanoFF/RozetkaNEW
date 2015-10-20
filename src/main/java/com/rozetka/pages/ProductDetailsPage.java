package com.rozetka.pages;

import org.openqa.selenium.By;

import com.rozetka.panels.SearchPane;

public class ProductDetailsPage extends SearchPane {
	
	private final By productTitle=By.cssSelector("h1[class='detail-title']");
	private final By wishList=By.xpath("//div[@name='wishlists']/a");
	
	public boolean doesProductHaveParametrs(String... parametrs){
		boolean has=true;
		for(String param: parametrs){
			if (getElementBy(productTitle).getText().contains(param)){
				has=false;
			}
		}
		return has;
	}
	
	//test

}
