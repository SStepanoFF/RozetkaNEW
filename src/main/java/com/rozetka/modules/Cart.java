package com.rozetka.modules;

import java.util.List;

import org.openqa.selenium.By;

import com.rozetka.utils.AbstractContainer;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class Cart extends AbstractContainer {
	
	private final By cartTitle=By.cssSelector("h2.cart-title");
	private final By closeCartBtn = By.cssSelector("a.popup-close");
	private final By goodsLink = By.cssSelector("a[name=goods-link]");
	
	public void closeCart(){
		clickElementBy(closeCartBtn);
	}
	
	public boolean onPage(){
		return isElementVisible(getElementBy(cartTitle));
	}
	
	public boolean itemExists(String itemName){
		boolean exists = false;
		String text;
		List<WebElementFacade> list = getAllElementsBy(goodsLink);
		
		for(int i=0; i<list.size(); i++){
			text  = getVisibleText(list.get(i)).toLowerCase();
			if(itemName.toLowerCase().contains(text)){
				exists=true;
			}
		}
		return exists;
		//return containsElementBy(goodsLink.linkText(itemName));
	}
}
