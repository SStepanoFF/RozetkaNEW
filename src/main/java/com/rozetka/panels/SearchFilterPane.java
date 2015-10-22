package com.rozetka.panels;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.WebElementFacade;

public class SearchFilterPane extends SearchPane {
	
	private final By categorySubList = By.cssSelector("li.m-cat-subl-i>a");
	//private final String a = "http://rozetka.com.ua/search/catalog/?text=apple&section_id=80004":
	
	//Categories-IDs list which is presented as key-value list
	private final Map<String, Integer> catIdMap = new HashMap<String, Integer>(){{
		put("notebooks",80004);
		put("smartphones",80003);
		put("tvs",80037);
	}};
	
	//It accepts only categories names that are listed in the catIdMap
	public void selectCategory(String category){
		boolean elementExists = false;
		if(catIdMap.containsKey(category)){
			
			//Get appropriate id
			String id = catIdMap.get(category).toString();
			
			//Get all categories from the filter pane
			List<WebElementFacade> options = getAllElementsBy(categorySubList);
			
			for(int i=0; i<options.size(); i++){
				WebElementFacade option = options.get(i);
				String uri = getAttributeOfWebElement(option, "href");
				if(uri.contains("section_id="+id)){
					clickWebElement(option);
					elementExists = true;
					if(elementExists) break;
				}
			} if(!elementExists){
				assertThat("The category: "+category+" does not exist on the page", false);
			}
		} else assertThat("The category: "+category+" does not exist in the HasMap. Please refer to the SearchFilterPane.class", false);
	}
}
