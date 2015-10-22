package com.rozetka.pages;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.openqa.selenium.By;

import com.rozetka.panels.SearchFilterPane;
import com.rozetka.panels.SearchPane;
import com.rozetka.utils.AbstractContainer;

import net.serenitybdd.core.pages.WebElementFacade;

public class SearchResultPage extends SearchFilterPane {

	//Locators
	private final By purchaseBtn = By.cssSelector("button.btn-link-i[name=topurchases]");
	
	private final String purchaseItemBtn="//preceding::div[@class='g-i-list-middle-part']/preceding::div[@class='g-tools-container']/div[@class='g-buy']/div/form/span/button";
	
	///
	//Locators
		
	//Item locators. Should be used under the appropriate item container
	//private final By buyItemButton = By.cssSelector("div.g-buy>div.toOrder>form>span>button.btn-link-i");
	private final By buyItemButton = By.cssSelector("button.btn-link-i");
	private final By itemLink = By.cssSelector("div.g-i-list-title>a");

	//Item Containters
	private final By availableItemContainerLocator = By.cssSelector("div.g-i-list.available[data-location=searchResults]");
	private final By outOfStockItemContainerLocator = By.cssSelector("div.g-i-list.unavailable[data-location=searchResults]");
	//private final By rightPartContainer = By.cssSelector("div.g-i-list-right-part")
	//private final By toolsContainter = By.cssSelector("div.g-tools-container]");

		
	public void buyItem(String itemName){
		WebElementFacade itemContainer;
		if(isItemAvailable(itemName)){
			itemContainer = getItemContainer(itemName);
			clickWebElement(getChildOfElementFacade(itemContainer, buyItemButton));
		} else{
			assertThat("The following item: "+itemName+" is out of stock", false);
		}	
	}
		
	public boolean isItemAvailable(String itemName){
		
		boolean isAvailable=false;
		
		WebElementFacade itemContainer = getItemContainer(itemName);
		
		
		if(itemContainer!=null){
			isAvailable=true;
		} else if(itemContainer==null){
			itemContainer=getItemContainer(itemName, false);
			if(itemContainer!=null){
				isAvailable=false;
			}else {
				assertThat("The following item: "+itemName+" does not exist either in available and out of stock.", false);
			}
		}
		return isAvailable;
	}
		
	private WebElementFacade getItemContainer(String itemName){
		return getItemContainer(itemName, true);
	}
		
	private WebElementFacade getItemContainer(String itemName, boolean available){
			
		List<WebElementFacade> itemContainers;
		
		if(!available){
			itemContainers = getAllElementsBy(outOfStockItemContainerLocator);
		}else{
			itemContainers = getAllElementsBy(availableItemContainerLocator);
		}
			
		for(int i=0; i<itemContainers.size(); i++){
			WebElementFacade elementContainer = itemContainers.get(i);
			WebElementFacade elementLink = getChildOfElementFacade(elementContainer, itemLink);
			if(elementLink.getText().toLowerCase().contains(itemName.toLowerCase())){
				return elementContainer;
			}
		}
		return null;
	}
	
	///
	public void goToItemPage(String itemName){
		clickElementBy(By.xpath("//a[contains(text(),\'"+itemName+"\']"));
	}
	
	@Deprecated
	public void purchaseItem(String itemName){
		clickWebElement(getChildOfElementFacade(findElementAtListByParametr(itemName), By.xpath(purchaseItemBtn)));
	}
	
	private WebElementFacade findElementAtListByParametr(String... parametr){
		boolean find=true;
		List<WebElementFacade> elements = getAllElementsBy(By.xpath("//div[@class=\'g-i-list-title\']/a"));
		for(WebElementFacade e: elements){
			for(String param: parametr ){
				if(!getAttributeOfWebElement(e, "innerHTML").toString().toLowerCase().contains(param.toLowerCase())){
					find=false;
					break;
				}
			}
			if(find){
				return e;
			}
		}
		assertThat("The element was not found", false);
		return null;
	} 
	
	public ProductDetailsPage openPDPSearchByParametr(String... parametr){
		findElementAtListByParametr(parametr).click();
		return new ProductDetailsPage();
	}
	
	@Deprecated
	public void clickPurchase(String itemName){
		clickElementBy(By.xpath("//a[contains(text(),\'"+itemName+"\']"+purchaseItemBtn));
	}
}
