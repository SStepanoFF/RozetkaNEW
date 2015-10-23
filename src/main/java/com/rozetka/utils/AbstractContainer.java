package com.rozetka.utils;

import static net.thucydides.core.webdriver.javascript.JavascriptSupport.javascriptIsSupportedIn;
import static org.hamcrest.MatcherAssert.assertThat;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.thoughtworks.selenium.Wait;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.jquery.JQueryEnabledPage;
import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;


public abstract class AbstractContainer extends PageObject{
	
	//protected static WebDriver driver = RWebDriver.getInstance().getWebDriver();
    //protected WebDriverWait wait=new WebDriverWait(driver,30);
	

   // public abstract String getBaseUrl();
   // public abstract By getUniqueElement();
    
    
	@Override
	public void addJQuerySupport() {
//        if (pageIsLoaded()) {
//            JQueryEnabledPage jQueryEnabledPage = JQueryEnabledPage.withDriver(getDriver());
//            if (jQueryEnabledPage.isJQueryIntegrationEnabled() && !jQueryEnabledPage.isJQueryAvailable()) {
////                jQueryEnabledPage.injectJQuery();
//                jQueryEnabledPage.injectJQueryPlugins();
//            }
//        }
    }
	
//	@Override
//	 public void setDriver(WebDriver driver) {
//        setDriver(RWebDriver.getInstance().getWebDriver(), getImplicitWaitTimeout().in(TimeUnit.MILLISECONDS));
//    }
	
//	private boolean pageIsLoaded() {
//        try {
//            return (getDriver().getCurrentUrl() != null);
//        } catch (WebDriverException e) {
//            return false;
//        }
//    }
//	
//	
//	public void injectJQuery() {
//        executeScriptFrom("jquery/jquery.min.js");
//        executeScriptFrom("jquery/jquery.focus.test-fix.js");
//    }
//	
//	protected void executeScriptFrom(String scriptSource) {
//		WebDriver driver=getDriver();
//        if (javascriptIsSupportedIn(driver)) {
//            String script = getFileAsString(scriptSource);
//            JavascriptExecutorFacade js = new JavascriptExecutorFacade(driver);
//            js.executeScript(script);
//        }
//    }
//	
//	 private String getFileAsString(final String resourcePath) {
//	        String content = "";
//	        try {
//	            URL fileUrl = getClass().getClassLoader().getResource(resourcePath);
//	            content = Resources.toString(fileUrl, Charsets.UTF_8);
//	        } catch (Exception e) {
//	            throw new RuntimeException(e);
//	        }
//	        return content;
//	    }
	
	protected void navigateToUrl(String url){
    	getDriver().navigate().to(url);
    }
    
    protected void waitForPageToLoad()
    {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>()
                {
                    public Boolean apply(WebDriver driver)
                    {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new WebDriverWait(getDriver(),30);
        try {
            wait.until(expectation);
        } catch (org.openqa.selenium.TimeoutException e){
        	assertThat("Page has not been loaded within 30 seconds", false);
        }
    }
    
    protected WebElementFacade getChildOfElementFacade(WebElementFacade elementFacade, By childBy) throws NullPointerException{
    	WebElementFacade element = elementFacade.findBy(childBy);
    	if(element.isVisible()){
    		return element;
    	}else{
    	assertThat("The child element: "+childBy.toString()+" of element: "+elementFacade.toString()+"is not visible", false);
    	return null;
    	}
    }
    
	protected WebElementFacade getElementBy(By by){
		List<WebElementFacade> elements = getAllElementsBy(by);
        for (WebElementFacade e : elements) {
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
	
	protected void clickWebElement(WebElementFacade element) {
        element.click();
        closeAlert();
	}
	
	protected WebElementFacade getParent(By by) {
		return getElementBy(by).find(By.xpath(".."));
        //return getElementBy(by).findElement(By.xpath(".."));
    }
	
	protected List<WebElementFacade> getAllElementsBy(By by){
		return findAll(by);
		//return driver.findElements(by);
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
	
    protected WebElementFacade findElementByAttributeValue(By by, String attribute, String value) {
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
	
	protected String getVisibleText(WebElementFacade element){
		return element.getText();
	}
	
	protected boolean containsElementBy(By by){
		return !getAllElementsBy(by).isEmpty();
	}
	
	protected boolean isElementVisible(WebElementFacade elementFacade){
		return elementFacade.isVisible();
	}
	
	protected void closeAlert() {
        try {
            System.out.println("Sytem shows the following message on the alert:\n" + getAlert().getText());
            getAlert().accept();
        } catch (NoAlertPresentException ex) {
        } 
    }
	
	protected void clearFieldBy(By by){
		getElementBy(by).clear();
	}
	
	protected void waitForElementBy(By by) {
		waitForRenderedElements(by);
    }
	
	protected void openURL(String url){
		getDriver().navigate().to(url);
	}
}
