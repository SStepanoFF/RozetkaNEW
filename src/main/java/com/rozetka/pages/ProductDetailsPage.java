package com.rozetka.pages;

import org.openqa.selenium.By;
import com.rozetka.panels.SearchPane;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://rozetka.com.ua/apple_macbook_air_zorj000n9/p2541567/")
public class ProductDetailsPage extends SearchPane {
	
	private final By productName =By.className("detail-tabs-i-title-inner");
	private final By productTitle=By.className("detail-title");
	private final By purchasesButon = By.cssSelector("button.btn-link-i[name=topurchases]");
	
	private final By shortCommentTabBtn=By.xpath("//ul[@class='clearfix']//li[2]/a");
	private final By commentTextField=By.cssSelector("textarea[name='text']");
	private final By commentNameField= By.cssSelector("input[name='name']");
	private final By commentEmailField= By.cssSelector("input[name='email']");
	private final By commentSubmitBtn= By.id("detail-tab-reviews-add-submit");
	
	private final By commentVerifyMessage=By.xpath("//div[@name='app-message']//div");
	private final By addedCommentsList= By.cssSelector("div[name='comment_vote']");
	private final String addedCommentText="p[class='pp-comments-i-text']";
	private final String addedCommentName="div[class='pp-comments-author-name']";
	
	//Wishlist Locators
	private final By addToWishlistBtn=By.xpath("//div[@name='wishlists']/a");
	private final By saveToWishlist= By.xpath("//div[@class='wishlists-i']//button");
	private final By closePopupMess= By.cssSelector("a[class='popup-close']");
	private final By popupWishAdded = By.cssSelector("h2[class='wishlists-title']");
	private final By wishCount= By.xpath("//div[@id='wishlist']//span[@class='hub-i-count']");
	
	public void openProdDetailsPage(String url){
		openURL(url);
		waitForPageToLoad();
	}
	
	public void clickBuy(){
		clickElementBy(purchasesButon);
	}
	
	public String getProductName(){
		return getElementBy(productName).getText().toLowerCase();
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
		clickElementBy(commentSubmitBtn);
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
//		boolean added=false;
//		for (WebElementFacade el:getAllElementsBy(addedCommentsList)){
//			if (el.findElement(By.cssSelector(addedCommentName)).getText().toLowerCase().contains(name.toLowerCase()) &&
//					el.findElement(By.cssSelector(addedCommentText)).getText().toLowerCase().contains(text.toLowerCase())){
//				added=true;
//			}
//		}
//		return added;
		return containsElementBy(commentVerifyMessage) && getElementBy(commentVerifyMessage).isEnabled();
	}
	
	public boolean isWishlistBtnAvailable(){
		return isElementVisible(addToWishlistBtn);
	}
	
	public void addToWishlist(){
		clickElementBy(addToWishlistBtn);
		clickElementBy(saveToWishlist);
		waitForElementBy(popupWishAdded);
	}
	
	public boolean isProductAddedToWishlist(){
		boolean added=true;
		if (containsElementBy(popupWishAdded)){
			if (!getElementBy(popupWishAdded).getText().toLowerCase().contains("добавлен")){
				added=false;
			}
			clickElementBy(closePopupMess);
		}else added=false;
		if (isWishListEmpty()){
			added=false;
		}
		return added;
	}
	
	public boolean isWishListEmpty(){
		if (containsElementBy(wishCount)){
			return false;
		}else return true;

	}
	
	public boolean onPage(){
		return isElementVisible(getElementBy(productName));
	}
}
