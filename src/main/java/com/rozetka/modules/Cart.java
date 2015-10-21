package com.rozetka.modules;

import org.openqa.selenium.By;

import com.rozetka.utils.AbstractContainer;

import net.serenitybdd.core.pages.PageObject;

public class Cart extends AbstractContainer {
	
	private static final By closeCartBtn = By.cssSelector("a.popup-close");
	private static final By goodsLink = By.cssSelector("a[name=goods-link]");
	
	public void closeCart(){
		clickElementBy(closeCartBtn);
	}
	
	public boolean itemExists(String itemName){
		return containsElementBy(goodsLink.linkText(itemName));
	}
}
