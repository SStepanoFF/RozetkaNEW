package com.rozetka.pages;

import org.openqa.selenium.By;

import com.rozetka.panels.SearchPane;
import com.rozetka.utils.AbstractContainer;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("http://rozetka.com.ua")
public class MainPage extends SearchPane {
	
	public void opens(){
		open();
	}
}
