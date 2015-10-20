package com.rozetka.pages;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.openqa.selenium.By;

import com.rozetka.panels.SearchPane;
import com.rozetka.utils.AbstractContainer;

import net.serenitybdd.core.pages.WebElementFacade;

public class SearchResultPage extends SearchPane {

	//Locators
	private static final By purchaseBtn = By.cssSelector("button.btn-link-i[name=topurchases]");
	
	private static final String purchaseItemBtn="//preceding::div[@class='g-i-list-middle-part']/preceding::div[@class='g-tools-container']/div[@class='g-buy']/div/form/span/button";

	public void goToItemPage(String itemName){
		clickElementBy(By.xpath("//a[contains(text(),\'"+itemName+"\']"));
	}
	
	public void purchaseItem(String itemName){
			clickWebElement(findElementAtListByParametr(itemName).findElement(By.xpath(purchaseItemBtn)));
	}
	
	private WebElementFacade findElementAtListByParametr(String... parametr){
		boolean find=true;
		List<WebElementFacade> elements = getAllElementsBy(By.xpath("//div[@class=\'g-i-list-title\']/a"));
		for(WebElementFacade e: elements){
			for(String param: parametr ){
				if(!getAttributeOfWebElement(e, "innerHTML").toString().contains(param)){
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
	
	public void clickPurchase(String itemName){
		clickElementBy(By.xpath("//a[contains(text(),\'"+itemName+"\']"+purchaseItemBtn));
	}
}
