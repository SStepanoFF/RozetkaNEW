package com.rozetka.pages;


import com.rozetka.panels.SearchPane;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("http://rozetka.com.ua")
public class MainPage extends SearchPane {
	
	private final String baseUrl = "http://rozetka.com.ua";
	
	public void openMainPage(){
		open();
		waitForPageToLoad();
	}
}
