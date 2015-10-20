package com.rozetka.pages;

import org.openqa.selenium.By;

import com.rozetka.panels.SearchPane;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://rozetka.com.ua/apple_macbook_air_zorj000n9/p2541567/")
public class ProductDetailsPage extends SearchPane {
	
	private final By productTitle=By.cssSelector("h1[class='detail-title']");
	
	public boolean doesProductHaveParametrs(String... parameters){
		boolean has=true;
		for(String param: parameters){
			if (!getElementBy(productTitle).getText().toLowerCase().contains(param.toLowerCase())){
				has=false;
			}
		}
		return has;
	}
	
	public void openPDP(){
		open();
	}

}
