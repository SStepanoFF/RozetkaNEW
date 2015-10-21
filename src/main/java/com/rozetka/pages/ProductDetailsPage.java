package com.rozetka.pages;

import org.openqa.selenium.By;

import com.rozetka.panels.SearchPane;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://rozetka.com.ua/apple_macbook_air_zorj000n9/p2541567/")
public class ProductDetailsPage extends SearchPane {
	
	private final By productTitle=By.cssSelector("h1[class='detail-title']");
	
	private final By shortCommentTabBtn=By.xpath("//ul[@class='clearfix']//li[2]/a");
	private final By commentTextField=By.cssSelector("textarea[name='text']");
	private final By commentNameField= By.cssSelector("input[name='name']");
	private final By commentEmailField= By.cssSelector("input[name='email']");
	private final By commentSubmitBtn= By.id("detail-tab-reviews-add-submit");
	
	private final By addedCommentsList= By.cssSelector("div[name='comment_vote']");
	private final String addedCommentText="p[class='pp-comments-i-text']";
	private final String addedCommentName="div[class='pp-comments-author-name']";
	
	public String getProductTitle(){
		return getElementBy(productTitle).getText().toLowerCase();
	}
	
	public boolean isProductHaveParametrs(String... parameters){
		boolean has=true;
		for(String param: parameters){
			if (!getElementBy(productTitle).getText().toLowerCase().contains(param.toLowerCase())){
				has=false;
			}
		}
		return has;
	}
	
	public void addComment(String text, String name, String email){
		openShortCommentTable();
		fillCommentsTable(email);
//		clickElementBy(commentSubmitBtn);
		getDriver().findElement(commentSubmitBtn).click();
	}
	
	private void openShortCommentTable(){
		clickElementBy(shortCommentTabBtn);
	}
	
	private void fillCommentsTable(String text){
		enterValueInTo(commentTextField, text);
		if (isSigninLinkPresent()){
			enterValueInTo(commentNameField, "test");
			enterValueInTo(commentEmailField, "tester1@test.com");
		}
	}
	
	public boolean isCommentAdded(String text, String name){
		boolean added=false;
		for (WebElementFacade el:getAllElementsBy(addedCommentsList)){
			if (el.findElement(By.cssSelector(addedCommentName)).getText().toLowerCase().contains(name.toLowerCase()) &&
					el.findElement(By.cssSelector(addedCommentText)).getText().toLowerCase().contains(text.toLowerCase())){
				added=true;
			}
		}
		return added;
	}
	
	public void openPDP(){
		open();
	}

}
