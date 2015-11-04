package com.rozetka.pages;

import com.rozetka.utils.AbstractContainer;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;

import com.rozetka.panels.SearchPane;

import net.serenitybdd.core.pages.WebElementFacade;

import java.util.ArrayList;
import java.util.List;

public class WishlistPage extends SearchPane{
	
	private final By uniqElement=By.cssSelector("h1.float-lt");

	private final By deleteSingleWishBtn= By.className("wishlist-g-i-remove");
	private final By emptyWishlistMess=By.xpath("//section[@class='wishlist-i']//h3[@class='wishlist-i-empty-title']");

	//Items Locators
	@FindBy (css = "div[name=wishlist-block-goods-item]")
	private List<WebElementFacade> wishlistItems;
	
	public boolean isPageOpened(){
		if(isElementVisible(uniqElement)){
			return true;
		}else return false;
	}

	public boolean isWishlistEmpty(){
		if (getAllItems().size()>0){
			return false;
		}else return true;
	}

	private ItemW findItemByName(String wishName){
		if (!isWishlistEmpty()){
			for (ItemW item: getAllItems()){
				if(item.getName().equalsIgnoreCase(wishName))return item;
			}
		}return null;
	}

	public boolean isWishPresent(String wishName){
		if(findItemByName(wishName)!=null){
			return true;
		}else return false;
	}

	public void deleteWishByName(String wishName){
		ItemW item=findItemByName(wishName);
		if (item!=null){
			item.deleteItem();
			}
	}
	
	public void deleteAllWishes(){
		if (!isWishlistEmpty()){
			List<ItemW> items=getAllItems();
			for (ItemW item: items){
				item.deleteItem();
			}
			waitForElementBy(emptyWishlistMess);
		}
	}

	private List<ItemW> getAllItems(){
		List<ItemW> itemList=new ArrayList<>();
		for(WebElementFacade elementFacade:wishlistItems){
			itemList.add(new ItemW(elementFacade));
		}
		return itemList;
	}
}

final class ItemW extends AbstractContainer{

	private WebElementFacade elementFacade;
	private final By title=By.className("g-i-tile-i-title");
	private final By deleteBtn=By.className("wishlist-g-i-remove");

	public ItemW(WebElementFacade elementFacade){
		this.elementFacade=elementFacade;
	}

	public String getName(){
		return getChildOfElementFacade(elementFacade,title).getText();
	}
	public void deleteItem(){
		clickWebElement(getChildOfElementFacade(elementFacade,deleteBtn));
	}

}
