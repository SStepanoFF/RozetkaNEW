package com.rozetka.utils;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.IsAlertPresent;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class AbstractContainer extends PageObject {
	

	protected WebElement getElementBy(By by){
		List<WebElementFacade> elements = getAllElementsBy(by);
        for (WebElement e : elements) {
            if (e.isDisplayed() && e.isEnabled()) {
                return e;
            }
        }
        return null;
	}

	protected void clickElementBy(By by){
		
		try{
		clickWebElement(getElementBy(by));
		}catch (NullPointerException e){
			assertThat("The element "+by.toString()+" is not enabled or visisble", false);
		}
	}
	
	protected void clickWebElement(WebElement element) {
        element.click();
        //closeAlert();
	}
	
	protected WebElement getParent(By by) {
        return getElementBy(by).findElement(By.xpath(".."));
    }
	
	protected List<WebElementFacade> getAllElementsBy(By by){
		return findAll(by);
	}
	
	protected void enterValueInTo(By by, String value){
		inputValue(getElementBy(by), value);
	}
	
    protected void inputValue(WebElement element, String text) {
        try {
        	assertThat("Cannot type text since element is not enabled", element.isEnabled());
            element.sendKeys(text);
            assertThat("The element: " + element.toString() + " contains value: " + element.getAttribute("value").toString() + " != " + text, element.getAttribute("value").contains(text));
        }catch (NullPointerException e){
        	assertThat("The element "+element.toString()+ " was not found", false);
        }
    }
    
    protected void selectRadioButton(By by) {
        selectRadioButton(getElementBy(by));
    }

    protected void selectRadioButton(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }
	
    protected WebElement findElementByAttributeValue(By by, String attribute, String value) {
        for (WebElementFacade element : getAllElementsBy(by)) {
            if (element.getAttribute(attribute).contains(value)) {
                return element;
            }
        }
        return null;
    }
    
	protected String getAttributeBy(By by, String attributeName){
		return getAttributeOfWebElement(getElementBy(by), attributeName);
	}
	
	protected String getAttributeOfWebElement(WebElement element, String attributeName){
		return element.getAttribute(attributeName).toString();
	}
	
	protected void selectFromDropDown(By by, String visibleText){
        WebElement dropDown=getElementBy(by);
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(visibleText);
        }catch (Exception e){
        	assertThat("Could not select the option with the following visible text: "+visibleText, false);
        }
    }
	
	protected boolean ContainsElementBy(By by){
		return !getAllElementsBy(by).isEmpty();
	}
	
	protected void closeAlert() {
        try {
            System.out.println("Sytem shows the following message on the alert:\n" + getAlert().getText().toString());
            getAlert().accept();
        } catch (NoAlertPresentException ex) {
        } 
    }
}
