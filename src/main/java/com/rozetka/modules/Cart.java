package com.rozetka.modules;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.openqa.selenium.By;

import com.rozetka.utils.AbstractContainer;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class Cart extends AbstractContainer {
	
	private final By cartTitle=By.cssSelector("h2.cart-title");
	private final By closeCartBtn = By.cssSelector("a.popup-close");
	
	//Locator
	private final By cartItemContainer = By.cssSelector("div.cart-i-content");
	private final By goodsLink = By.cssSelector("a[name=goods-link]");
	
	
	public Integer getItemPositionInTheCart(String itemName){
		Integer position=0;
		if(isItemInTheCart(itemName)){
			
			List<WebElementFacade> itemContainers = getAllElementsBy(cartItemContainer);
			
			for(int i=0; i<itemContainers.size(); i++){
				WebElementFacade elementContainer = itemContainers.get(i);
				WebElementFacade elementLink = getChildOfElementFacade(elementContainer, goodsLink);
				if(elementLink.getText().toLowerCase().contains(itemName.toLowerCase())){
					position=i+1;
				}
			}
		}
		return position;
	}
	
	public boolean isItemInTheCart(String itemName){
		boolean exists=false;
		if(getItemContainer(itemName)!=null){
			exists=true;
		}
		return exists;
	}
	
	private WebElementFacade getItemContainer(String itemName){
		
		List<WebElementFacade> itemContainers = null;
		itemContainers = getAllElementsBy(cartItemContainer);
		
		for(int i=0; i<itemContainers.size(); i++){
			WebElementFacade elementContainer = itemContainers.get(i);
			WebElementFacade elementLink = getChildOfElementFacade(elementContainer, goodsLink);
			if(elementLink.getText().toLowerCase().contains(itemName.toLowerCase())){
				return elementContainer;
			}
		}
		return null;
	}
	
	public void closeCart(){
		clickElementBy(closeCartBtn);
	}
	
	public boolean onPage(){
		return isElementVisible(getElementBy(cartTitle));
	}
	
	@Deprecated //Use isItemInTheCart instead
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
