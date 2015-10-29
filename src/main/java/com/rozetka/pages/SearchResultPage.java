package com.rozetka.pages;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.rozetka.panels.SearchFilterPane;
import com.rozetka.panels.SearchPane;
import com.rozetka.utils.AbstractContainer;

import net.serenitybdd.core.pages.WebElementFacade;
import sun.security.x509.AVA;

public class SearchResultPage extends SearchFilterPane {

	//Locators
	private final By purchaseBtn = By.cssSelector("button.btn-link-i[name=topurchases]");
	private final String purchaseItemBtn="//preceding::div[@class='g-i-list-middle-part']/preceding::div[@class='g-tools-container']/div[@class='g-buy']/div/form/span/button";
	private final By buyItemButton = By.cssSelector("button.btn-link-i");
	private final By itemLink = By.cssSelector("div.g-i-list-title>a");

	//Item Containters
	private final By availableItemContainerLocator = By.cssSelector("div.g-i-list.available[data-location=searchResults]");
	private final By outOfStockItemContainerLocator = By.cssSelector("div.g-i-list.unavailable[data-location=searchResults]");
	private final By limitedItemContainerLocator = By.cssSelector("div.g-i-list.limited[data-location=searchResults]");
	private final By archiveItemContainerLocator = By.cssSelector("div.g-i-list.archive[data-location=searchResults]");

	@Deprecated
//	public void buyItem(String itemName, String additionalSearchCriteria){
//		String additional=null;
//		if(additionalSearchCriteria!=null){
//			additional=additionalSearchCriteria;
//		}
//		WebElementFacade itemContainer;
//		if(isItemAvailable(itemName, additional)){
//			itemContainer = getItemContainer(itemName,"available",additional);
//			clickWebElement(getChildOfElementFacade(itemContainer, buyItemButton));
//		} else if(isItemLimited(itemName, additional)){
//			itemContainer = getItemContainer(itemName, "limited", additional);
//			clickWebElement(getChildOfElementFacade(itemContainer, buyItemButton));
//		} else if(isItemArchieved(itemName, additional)){
//			assertThat("The following item: "+itemName+" is archived", false);
//		} else if(isItemUnavailable(itemName, additional)){
//			assertThat("The following item: "+itemName+" is out of stock", false);
//		}
//	}
	public void buyItem(String itemName){
		buyItem(itemName, null);
	}

	public void buyItem(String itemName, String additionalSearchCriteria){

		List<Item> allItemsOnPage=getAllAvailableItems();
		boolean found=false;

		if(allItemsOnPage.size()>0){
			for(Item i : allItemsOnPage){
				if(i.getItemName().toLowerCase().contains(itemName.toLowerCase())){
					if(additionalSearchCriteria!=null){
						if (i.getItemName().toLowerCase().contains(additionalSearchCriteria.toLowerCase())){
							i.clickBuy();
							found=true;
						}
					} else {
						i.clickBuy();
						found = true;
					}
				}
				if (found) break;
			}
		}

		if (!found){
			allItemsOnPage=getAllLimitedItems();

			if(allItemsOnPage.size()>0){
				for(Item i : allItemsOnPage){
					if(i.getItemName().toLowerCase().contains(itemName.toLowerCase())){
						if(additionalSearchCriteria!=null){
							if (i.getItemName().toLowerCase().contains(additionalSearchCriteria.toLowerCase())){
								i.clickBuy();
								found=true;
							}
						} else {
							i.clickBuy();
							found = true;
						}
					}
					if (found) break;
				}
			}

			if (!found){
				assertThat("The item "+itemName+ " is not in stock", false);
			}
		}
	}
		
//	public boolean isItemAvailable(String itemName, String additionalSearchCriteria){
//		String additional=null;
//		if(additionalSearchCriteria!=null){
//			additional=additionalSearchCriteria;
//		}
//		boolean isAvailable=false;
//
//		WebElementFacade itemContainer = getItemContainer(itemName, "available" ,additional);
//
//		if(itemContainer!=null){
//			isAvailable=true;
//		}
//		return isAvailable;
//	}
//
//	public boolean isItemUnavailable(String itemName, String additionalSearchCriteria){
//		String aditional=null;
//		if(additionalSearchCriteria!=null){
//			aditional=additionalSearchCriteria;
//		}
//		boolean isUnavailable=false;
//
//		WebElementFacade itemContainer = getItemContainer(itemName, "unavailable", aditional);
//
//		if(itemContainer!=null){
//			isUnavailable=true;
//		}
//		return isUnavailable;
//	}
//
//	public boolean isItemLimited(String itemName, String additionalSearchCriteria){
//		String aditional=null;
//		if(additionalSearchCriteria!=null){
//			aditional=additionalSearchCriteria;
//		}
//		boolean isLimited=false;
//
//		WebElementFacade itemContainer = getItemContainer(itemName, "limited", aditional);
//
//		if(itemContainer!=null){
//			isLimited=true;
//		}
//		return isLimited;
//	}
//
//	public boolean isItemArchieved(String itemName, String additionalSearchCriteria){
//		String aditional=null;
//		if(additionalSearchCriteria!=null){
//			aditional=additionalSearchCriteria;
//		}
//		boolean isArchive=false;
//
//		WebElementFacade itemContainer = getItemContainer(itemName, "archive", aditional);
//
//		if(itemContainer!=null){
//			isArchive=true;
//		}
//		return isArchive;
//	}

		
	//It accepts only 'available', 'unavailable', 'limited', 'archive' 
//	private WebElementFacade getItemContainer(String itemName, String exists, String additionSearchCriteria){
//
//		List<WebElementFacade> itemContainers = null;
//
//		if(exists=="unavailable"){
//			itemContainers = getAllElementsBy(outOfStockItemContainerLocator);
//		}else if(exists=="available"){
//			itemContainers = getAllElementsBy(availableItemContainerLocator);
//		}else if(exists=="limited"){
//			itemContainers = getAllElementsBy(limitedItemContainerLocator);
//		} else if(exists=="archive"){
//			itemContainers = getAllElementsBy(archiveItemContainerLocator);
//		} else{
//			assertThat("The getItemContainer method in the SearchResultPage only accepts 'available', 'unavailable', 'limited', 'archive' values in the exists parameter", false);
//		}
//
//		for(int i=0; i<itemContainers.size(); i++){
//			WebElementFacade elementContainer = itemContainers.get(i);
//			WebElementFacade elementLink = getChildOfElementFacade(elementContainer, itemLink);
//			if(elementLink.getText().toLowerCase().contains(itemName.toLowerCase())){
//				if(additionSearchCriteria!=null){
//					if(elementLink.getText().toLowerCase().contains(additionSearchCriteria.toLowerCase())){
//						return elementContainer;
//					}
//				}else{
//					return elementContainer;
//				}
//			}
//		}
//		return null;
//	}
	
	///
	@Deprecated
	public void goToItemPage(String itemName, String additionalSearchCriteria){
		//clickWebElement(findElementAtListByParametr(itemName, additionalSearchCriteria));


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

	@Deprecated
	public ProductDetailsPage openPDPSearchByParametr(String... parametr){
		findElementAtListByParametr(parametr).click();
		return new ProductDetailsPage();
	}
	
	@Deprecated
	public void clickPurchase(String itemName){
		clickElementBy(By.xpath("//a[contains(text(),\'"+itemName+"\']"+purchaseItemBtn));
	}
	///////////////
	//////////////

	public List<Item> getAllAvailableItems(){
		return getItems(availableItemContainerLocator);
	}

	public List<Item> getAllUnavailableItems(){
		return getItems(outOfStockItemContainerLocator);
	}

	public List<Item> getAllLimitedItems(){
		return getItems(limitedItemContainerLocator);
	}

	public List<Item> getAllArchivedItems(){

		return getItems(archiveItemContainerLocator);
	}


	private List<Item> getItems(By itemContainerLocator){
		List<Item> items = new ArrayList<Item>();
		List<WebElementFacade> elements = getAllElementsBy(itemContainerLocator);

		for(WebElementFacade element : elements){
			items.add(new Item(element));
		}
		return items;
	}
}

final class Item extends AbstractContainer{
	private WebElementFacade item;
	//Locators
	private final By buyItemButton = By.cssSelector("button.btn-link-i");
	private final By itemLink = By.cssSelector("div.g-i-list-title>a");


	public Item(WebElementFacade element){
		this.item=element;
	}

	public void clickBuy(){
		clickWebElement(getChildOfElementFacade(item, buyItemButton));
	}

	public String getItemName(){
		return getVisibleText(getChildOfElementFacade(item, itemLink));
	}

	public void clickOnItemName(){
		clickWebElement(getChildOfElementFacade(item, itemLink));
	}
}
//////////////////////////////
/////////////////////////////